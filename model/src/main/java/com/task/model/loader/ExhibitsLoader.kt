package com.task.model.loader

import com.task.model.entities.Exhibit

interface ExhibitsLoader {
   suspend fun getExhibitList(): List<Exhibit>
}