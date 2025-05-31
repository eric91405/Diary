package com.example.diary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diary.databinding.FragmentDiaryBinding

class DiaryFragment : Fragment() {

    private var _binding: FragmentDiaryBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: DiaryAdapter

    private val viewModel: DiaryViewModel by viewModels {
        DiaryViewModelFactory((requireActivity().application as DiaryApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDiaryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = DiaryAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        viewModel.allDiaries.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        // 저장 버튼이 없으므로 저장 관련 코드는 삭제하거나
        // 저장 기능은 다른 곳(예: 메뉴, FAB, 자동 저장 등)에서 구현하세요
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
