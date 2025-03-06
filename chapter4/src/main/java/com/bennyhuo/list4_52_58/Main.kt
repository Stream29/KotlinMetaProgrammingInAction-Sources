package com.bennyhuo.list4_52_58

import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import java.io.File

fun main() {
  // 4-52
  // FileSpec 是 Kotlin 源文件的描述类
  FileSpec.builder(
    "com.bennyhuo.kotlin.meta",
    "HelloWorld.kt"
  )
    // 导入 Kotlin 默认的包，例如 kotlin.collections
    .addKotlinDefaultImports(includeJvm = false, includeJs = false)
    // 添加文件注释
    .addFileComment("This is generated by KotlinPoet.")
    // 添加函数，这在 Java 当中对应于方法（method）
    .addFunction(
      FunSpec.builder("main")
        .addParameter("args", String::class, KModifier.VARARG)
        // 注意 KotlinPoet 的格式化符使用 % 引导，JavaPoet 当中使用 $
        .addStatement("println(%S)", "Hello World")
        .build()
    )
    .build()
    .writeTo(File("data"))
}