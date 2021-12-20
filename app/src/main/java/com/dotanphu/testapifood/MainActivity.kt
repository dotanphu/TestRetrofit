package com.dotanphu.testapifood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.dotanphu.testapifood.adapter.CategoryAdapter
import com.dotanphu.testapifood.databinding.ActivityMainBinding
import com.dotanphu.testapifood.model.Category
import com.dotanphu.testapifood.model.CategoryRespone
import com.dotanphu.testapifood.network.CategoryClient
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: CategoryAdapter
    private lateinit var binding: ActivityMainBinding
    private val category = arrayListOf<Category>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = CategoryAdapter(category)
        binding.rvCategory.adapter = adapter
        binding.rvCategory.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        getFoodVersion()
    }

    fun getFoodVersion() {
        lifecycleScope.launch(Dispatchers.IO) {
            var reponse: Response<CategoryRespone> = CategoryClient().getFoodVersion().execute()
            if (reponse.isSuccessful) {
                reponse.body()?.categpory?.let {
                    category.addAll(it)
                }
                withContext(Dispatchers.Main) {
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }
}