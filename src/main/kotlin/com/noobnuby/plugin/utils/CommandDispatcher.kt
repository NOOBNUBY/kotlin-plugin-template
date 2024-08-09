package com.noobnuby.plugin.utils

import com.noobnuby.plugin.Main.Companion.instance

inline fun commands(register: () -> Unit) { register() }
