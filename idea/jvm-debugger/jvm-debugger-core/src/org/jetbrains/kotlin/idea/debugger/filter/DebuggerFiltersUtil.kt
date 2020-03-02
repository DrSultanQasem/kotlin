/*
 * Copyright 2010-2015 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.idea.debugger.filter

import com.intellij.debugger.settings.DebuggerSettings
import com.intellij.ui.classFilter.ClassFilter
import org.jetbrains.kotlin.idea.debugger.KotlinDebuggerSettings

private const val KOTLIN_STDLIB_FILTER = "kotlin.*"

fun addKotlinStdlibDebugFilterIfNeeded() {
    if (!KotlinDebuggerSettings.getInstance().DEBUG_IS_FILTER_FOR_STDLIB_ALREADY_ADDED) {
        val settings = DebuggerSettings.getInstance()!!
        val newFilters = (settings.steppingFilters + ClassFilter(KOTLIN_STDLIB_FILTER))

        settings.steppingFilters = newFilters

        KotlinDebuggerSettings.getInstance().DEBUG_IS_FILTER_FOR_STDLIB_ALREADY_ADDED = true
    }
}

