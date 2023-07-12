/*
 * Copyright 2023 Oliver Berg
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.ormr.ieseditor.views

import net.ormr.ieseditor.utils.iesEditorConfig
import net.ormr.ieseditor.utils.openIesEditorView
import tornadofx.*

class MainView : View("IES Editor") {
    private val hasRecentFile = booleanBinding(iesEditorConfig.lastIesFileProperty) { value != null }
    
    override val root = vbox {
        button("Open File..") {
            action {
                val file = chooseIesFile()
                if (file != null) openIesEditorView(file)
            }
        }
        button("Open Recent File..") {
            enableWhen(hasRecentFile)
            action {
                val file = iesEditorConfig.lastIesFile
                if (file != null) openIesEditorView(file)
            }
        }
    }
}