package release

import controllers.Application
import views.ViewsFactory
import views.swing.SwingFactory

fun main(args: Array<String>) {
    val app = object : Application() {
        override fun makeViewsFactory(): ViewsFactory {
            return SwingFactory()
        }
    }

    app.start()
}