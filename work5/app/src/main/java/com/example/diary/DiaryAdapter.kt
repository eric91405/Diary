package com.example.diary

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.diary.databinding.ItemDiaryBinding

class DiaryAdapter : ListAdapter<Diary, DiaryAdapter.DiaryViewHolder>(DiaryDiffCallback()) {

    inner class DiaryViewHolder(private val binding: ItemDiaryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(diary: Diary) {
            binding.titleTextView.text = diary.title
            binding.contentTextView.text = diary.content
            binding.dateTextView.text = diary.date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiaryViewHolder {
        val binding = ItemDiaryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DiaryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DiaryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class DiaryDiffCallback : DiffUtil.ItemCallback<Diary>() {
    override fun areItemsTheSame(oldItem: Diary, newItem: Diary) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Diary, newItem: Diary) = oldItem == newItem
}
