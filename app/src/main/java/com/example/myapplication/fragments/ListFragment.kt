package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ListFragmentBinding
import com.example.myapplication.recView.RecyclerViewAdapter
import com.example.myapplication.viewModels.BaseViewModel

class ListFragment : Fragment() {

    private var dataAdapter = RecyclerViewAdapter()
    private var baseViewModel: BaseViewModel? = null
    private var _binding: ListFragmentBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = ListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        baseViewModel = ViewModelProvider(requireActivity())[BaseViewModel::class.java]
        baseViewModel?.getList()
        binding.recyclerView.adapter = dataAdapter
        baseViewModel?.data?.observe(viewLifecycleOwner) {
            binding.progressBar.visibility = View.GONE
            dataAdapter.submitList(it)
        }
        baseViewModel?.internetConnection?.observe(viewLifecycleOwner){
            Toast.makeText(context, "No Internet Connection + $it", Toast.LENGTH_LONG).show()
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}