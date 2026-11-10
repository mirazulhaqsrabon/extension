
package com.extension.template

import android.content.res.Resources

class AstroFileType(
    resources: Resources
) : FileType {

    override val extensions = listOf("astro")

    override val textmateScope = "source.astro"

    override val name = "astro"

    override val title = "Astro"
}
