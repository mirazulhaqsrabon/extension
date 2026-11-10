
class AstroFileType(
    resources: Resources
) : FileType {

    override val extensions = listOf("astro")

    override val textmateScope = "source.astro"

    override val icon =
        Icon.ExternalResourceIcon(
            R.drawable.ic_astro,
            resources
        )

    override val name = "astro"

    override val title = "Astro"
}
