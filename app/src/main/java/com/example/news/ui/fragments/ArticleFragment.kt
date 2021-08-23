package com.example.news.ui.fragments

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.navArgs
import com.example.news.R
import com.example.news.ui.MainActivity
import com.example.news.ui.NewsViewModel
import kotlinx.android.synthetic.main.fragment_article.*

class ArticleFragment : Fragment(R.layout.fragment_article) {

    lateinit var viewModel: NewsViewModel
    val args: ArticleFragmentArgs by navArgs()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        val article = args.article
        webView.apply {
            webViewClient = webViewClient
            loadUrl(article.url)
        }
    }
}

