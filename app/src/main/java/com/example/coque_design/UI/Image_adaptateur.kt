package com.example.coque_design.UI

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coque_design.ImageFragment
import com.example.coque_design.R
import com.example.coque_design.ServiceData.Image
import com.example.coque_design.databinding.RecycleViewImageBinding

class Image_adaptateur(private val data: List<Image>, val parentFragment: Fragment) : RecyclerView.Adapter<Image_adaptateur.ImageViewHolder>(){
    companion object{
        private const val TAG = "RecyclerTownAdapter"
    }

    init {
        Log.d(TAG, "onBindViewHolder position=${data.size}")
    }
    inner class ImageViewHolder(val binding: RecycleViewImageBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder { //pour creer le nombre d'item qu'il aurait à afficher
        Log.d(TAG, "onCreateViewHolder")

        val binding = RecycleViewImageBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {  // pour afficher les items
        Log.d(TAG, "onBindViewHolder position=${position}")

        val image: Image = data[position]
        Log.d(TAG, " Image de l'album ${image.portrait}")
        val media = image.portrait

        try {
            ImageFragment.fragmentContext?.let {
                Glide.with(it)
                    .load(media)
                    .into(holder.binding.imageCoque)
            }
        } catch (e: Throwable) {
            e.printStackTrace()

            Log.e(TAG, "Glide", e)
        }


        holder.binding.card.setOnClickListener {
            val navController = parentFragment.findNavController()
            navController?.navigate(R.id.action_imageFragment_to_coque)
        }

    }
}