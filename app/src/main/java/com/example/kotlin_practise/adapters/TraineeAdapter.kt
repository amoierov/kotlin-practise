package com.example.kotlin_practise.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_practise.MyDiffUtil
import com.example.kotlin_practise.R
import com.example.kotlin_practise.databinding.TraineeItemBinding
import com.example.kotlin_practise.models.*

class TraineeAdapter(private var traineeList: MutableList<Trainee>) : RecyclerView.Adapter<TraineeAdapter.TraineeHolder>(){
    class TraineeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = TraineeItemBinding.bind(itemView)
        fun bind(trainee: Trainee) {
            binding.textViewName.text = "Name: ${trainee.name}"
            binding.textViewAge.text = "Age: ${trainee.age}"
            binding.textViewStage.text = "Stage: ${trainee.currentStage}"
            binding.textViewScore.text = "Scores: ${trainee.codeReviewScores.joinToString()}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TraineeHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.trainee_item, parent, false)
        return TraineeHolder(view)
    }

    override fun getItemCount(): Int {
        return traineeList.size
    }

    override fun onBindViewHolder(holder: TraineeHolder, position: Int) {
        val trainee = traineeList[position]
        holder.bind(trainee)
    }

    fun setData(newTraineeList: MutableList<Trainee>) {
        val diffUtil = MyDiffUtil(traineeList, newTraineeList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        traineeList = newTraineeList
        diffResult.dispatchUpdatesTo(this)
    }
}