package com.example.kotlin_practise

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_practise.adapters.CardAdapter
import com.example.kotlin_practise.adapters.DublicateAdapter
import com.example.kotlin_practise.models.MyModel
import com.example.kotlin_practise.models.modelInstance1
import com.example.kotlin_practise.models.modelInstance2
import com.example.kotlin_practise.models.modelInstance3
import com.example.kotlin_practise.models.modelInstance4
import com.google.android.flexbox.FlexboxLayoutManager


class DublicateModelFragment : BaseFragment(R.layout.fragment_dublicate_model) {



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list1 = listOf(modelInstance1, modelInstance2)
        val list2 = listOf(modelInstance3, modelInstance4)

        val combinedList = list1 + list2

        val hashmap = find_dublicate(combinedList)
        removeEntriesWithSpecificValue(hashmap, 1)
        val recyclerView: RecyclerView = view.findViewById(R.id.rcViewDublicate)
        val adapter = DublicateAdapter(hashmap)
        recyclerView.adapter = adapter
        val layoutManager = FlexboxLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager
    }


}
fun find_dublicate (combinedList: List<MyModel>): HashMap<String, Int> {
    val hashMap = HashMap<String, Int>()
    for (model in combinedList ){
        val userName = model.userName
        var count = hashMap.getOrDefault(userName, 0)
        hashMap[userName] = count + 1

        val picture = model.picture.toString()
        count = hashMap.getOrDefault(picture, 0)
        hashMap[picture] = count + 1

        val description = model.description
        count = hashMap.getOrDefault(description, 0)
        hashMap[description] = count + 1

        val signature = model.signature
        count = hashMap.getOrDefault(signature, 0)
        hashMap[signature] = count + 1

        val tags = model.tags.joinToString(", ")
        count = hashMap.getOrDefault(tags, 0)
        hashMap[tags] = count + 1
    }
    return hashMap
}

/**
 * Remove entries with specific value
 * Фукнция удалят пары key-value, в которых
 * содержится valueToRemove
 * @param map
 * @param valueToRemove
 */
fun removeEntriesWithSpecificValue(map: HashMap<String, Int>, valueToRemove: Int) {
    val iterator = map.entries.iterator()

    while (iterator.hasNext()) {
        val entry = iterator.next()
        if (entry.value == valueToRemove) {
            iterator.remove()
        }
    }
}

