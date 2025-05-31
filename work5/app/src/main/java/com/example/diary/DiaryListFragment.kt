package com.example.diary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diary.databinding.FragmentDiaryListBinding

class DiaryListFragment : Fragment() {

    private var _binding: FragmentDiaryListBinding? = null
    private val binding get() = _binding!!

    private lateinit var diaryAdapter: DiaryAdapter
    private val diaryViewModel: DiaryViewModel by viewModels {
        DiaryViewModelFactory((requireActivity().application as DiaryApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDiaryListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        diaryAdapter = DiaryAdapter(emptyList()) { diary ->
            diaryViewModel.delete(diary.id)
        }

        binding.recyclerViewDiaries.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = diaryAdapter
        }

        diaryViewModel.allDiaries.observe(viewLifecycleOwner) { diaries ->
            diaryAdapter.updateList(diaries)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
