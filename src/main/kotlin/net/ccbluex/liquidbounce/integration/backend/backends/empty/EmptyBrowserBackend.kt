/*
 * This file is part of LiquidBounce (https://github.com/CCBlueX/LiquidBounce)
 *
 * Copyright (c) 2015 - 2025 CCBlueX
 *
 * LiquidBounce is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * LiquidBounce is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with LiquidBounce. If not, see <https://www.gnu.org/licenses/>.
 */
package net.ccbluex.liquidbounce.integration.backend.backends.empty

import net.ccbluex.liquidbounce.integration.backend.BrowserBackend
import net.ccbluex.liquidbounce.integration.backend.browser.BrowserSettings
import net.ccbluex.liquidbounce.integration.backend.browser.BrowserViewport
import net.ccbluex.liquidbounce.integration.backend.input.InputAcceptor
import net.ccbluex.liquidbounce.integration.task.TaskManager

/**
 * An empty browser backend implementation for platforms where JCEF is not supported (e.g., iOS).
 * This backend does nothing and is used to prevent crashes on unsupported platforms.
 *
 * @author CCBlueX
 */
class EmptyBrowserBackend : BrowserBackend {
    override val isInitialized: Boolean = true
    override var browsers = mutableListOf<BrowserBackend.Browser>()
    override var isAccelerationSupported: Boolean = false

    override fun makeDependenciesAvailable(taskManager: TaskManager, whenAvailable: () -> Unit) {
        // Do nothing, as there are no dependencies to download or initialize
        whenAvailable()
    }

    override fun start() {
        // Do nothing, as there is no browser to start
    }

    override fun stop() {
        // Do nothing, as there is no browser to stop
    }

    override fun update() {
        // Do nothing, as there is no browser to update
    }

    override fun createBrowser(
        url: String,
        position: BrowserViewport,
        settings: BrowserSettings,
        priority: Short,
        inputAcceptor: InputAcceptor?
    ): BrowserBackend.Browser {
        // Return a dummy browser implementation
        return object : BrowserBackend.Browser {
            override var viewport: BrowserViewport = position
            override var url: String = url
            override var zoomLevel: Double = 0.0
            override var focused: Boolean = false
            override var settings: BrowserSettings = settings

            override fun resize(width: Int, height: Int) {
                // Do nothing
            }

            override fun close() {
                // Do nothing
            }

            override fun sendMouseClick(x: Int, y: Int, button: Int, action: Boolean) {
                // Do nothing
            }

            override fun sendMouseMove(x: Int, y: Int) {
                // Do nothing
            }

            override fun sendMouseWheel(delta: Double) {
                // Do nothing
            }

            override fun sendKeyPress(keyCode: Int, scanCode: Int, modifiers: Int) {
                // Do nothing
            }

            override fun sendKeyRelease(keyCode: Int, scanCode: Int, modifiers: Int) {
                // Do nothing
            }

            override fun sendKeyTyped(character: Char, modifiers: Int) {
                // Do nothing
            }

            override fun sendKeyTyped(string: String, modifiers: Int) {
                // Do nothing
            }

            override fun executeJavaScript(script: String) {
                // Do nothing
            }

            override fun reload() {
                // Do nothing
            }

            override fun goBack() {
                // Do nothing
            }

            override fun goForward() {
                // Do nothing
            }

            override fun loadUrl(url: String) {
                // Do nothing
            }
        }.apply { browsers.add(this) }
    }
}