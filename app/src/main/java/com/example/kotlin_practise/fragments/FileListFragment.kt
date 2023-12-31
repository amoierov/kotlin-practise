package com.example.kotlin_practise.fragments

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin_practise.R
import com.example.kotlin_practise.adapters.FileAdapter
import com.example.kotlin_practise.adapters.FileItem
import com.example.kotlin_practise.databinding.FragmentFileListBinding
import com.google.android.flexbox.FlexboxLayoutManager
import java.io.File

class FileListFragment : BaseFragment(R.layout.fragment_file_list) {

    private val binding by viewBinding(FragmentFileListBinding::bind)
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = binding.recyclerView
        val layoutManager = FlexboxLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager

        checkStoragePermission()

        val downloadDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
        val fileAdapter = FileAdapter(getFilesInDirectory(downloadDirectory)) {navigateTo(R.id.action_fileListFragment_to_dublicateModelFragment)}
        recyclerView.adapter = fileAdapter
    }

    private fun getFilesInDirectory(directory: File): List<FileItem> {
        val fileList = mutableListOf<FileItem>()
        val files = directory.listFiles()


        files?.let {
            for (file in it) {
                if (file.isDirectory) {
                    // Рекурсивно добавляем файлы из вложенной папки
                    fileList.addAll(getFilesInDirectory(file))
                } else {
                    fileList.add(FileItem(file.name))
                }
            }
        }

        return fileList
    }



    @RequiresApi(Build.VERSION_CODES.R)
    private fun checkStoragePermission() {
        // Проверяем, предоставлено ли разрешение
        if (ContextCompat.checkSelfPermission(
                requireActivity(),
                Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            // Разрешение не предоставлено, вызываем экран настроек
            openAppSettings()
        }
    }
    @RequiresApi(Build.VERSION_CODES.R)
    private fun openAppSettings() {
        // Открывает экран настроек приложения для предоставления пользователю возможности выдать разрешение вручную
        startActivity(
            Intent(
                Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION,
                Uri.parse("package:com.example.kotlin_practise")
            )
        )
    }
}