package com.example.kotlin_practise

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.File

class FileListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var fileAdapter: FileAdapter

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_file_list, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        checkStoragePermission()

        val downloadDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
        fileAdapter = FileAdapter(getFilesInDirectory(downloadDirectory))
        recyclerView.adapter = fileAdapter

        return view
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