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

package net.ormr.tos.cli.ies.format

import com.github.ajalt.clikt.parameters.groups.OptionGroup
import net.ormr.tos.cli.ies.IesFormatCommand
import net.ormr.tos.ies.element.Ies
import net.ormr.tos.ies.element.IesColumn
import net.ormr.tos.ies.element.IesField
import java.nio.file.Path

sealed class IesFormat(name: String, protected val command: IesFormatCommand) : OptionGroup(name = name) {
    abstract val fileExtension: String

    abstract fun loadFrom(file: Path): Ies?

    abstract fun writeTo(file: Path, ies: Ies)

    protected fun IesColumn<*>.isManualColumn(): Boolean = name == "ClassID" || name == "ClassName"

    protected fun IesField<*, *>.isManualField(): Boolean = name == "ClassID" || name == "ClassName"
}