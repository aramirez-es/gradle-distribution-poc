package org.gradle.distribution

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.*
import java.io.File
import java.io.FileOutputStream
import java.net.URL

open class DownloadGradle: DefaultTask() {
    @Input
    lateinit var gradleVersion: String

    @InputDirectory
    lateinit var destinationDir: File

    private val gradleDownloadBase = "https://downloads.gradle-dn.com/distributions"

    @TaskAction
    fun doDownloadGradle() = getDestinationFile().outputStream().use {
        fileOutputStream: FileOutputStream -> URL(getDownloadUrl()).openStream().copyTo(fileOutputStream)
    }

    @Internal
    fun getDistributionNameBase() = "gradle-$gradleVersion"
    private fun getDownloadFileName() = getDistributionNameBase() + "-bin.zip"
    private fun getDownloadUrl() = "$gradleDownloadBase/" + getDownloadFileName()

    @OutputFile
    fun getDestinationFile() = File(destinationDir, getDownloadFileName())
}
