package com.extension.template

import androidx.annotation.Keep
import com.rk.extension.ExtensionAPI
import com.rk.extension.ExtensionContext

@Keep
@Suppress("unused")
class Main(context: ExtensionContext) : ExtensionAPI(context) {

    private var fileResolver: AssetsFileResolver? = null
    private var astroFileType: AstroFileType? = null

    override fun onLoad() {

        fileResolver = AssetsFileResolver(context.assets)

        FileProviderRegistry.getInstance()
            .addFileProvider(fileResolver!!)

        GrammarRegistry.getInstance()
            .loadGrammars("languages.json")

        val astro = AstroFileType(context.resources)

        astroFileType = astro

        FileTypeManager.register(astro)
    }

    override fun onDispose() {

        fileResolver?.let {
            FileProviderRegistry.getInstance()
                .removeFileProvider(it)
        }

        astroFileType?.let {
            FileTypeManager.unregister(it)
        }
    }
}
