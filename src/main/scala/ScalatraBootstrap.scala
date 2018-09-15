import org.scalatra.LifeCycle

import com.gaguena.sblog.controller.rest.PostingRest

import javax.servlet.ServletContext
import com.gaguena.sblog.database.DataBaseSupport

class ScalatraBootstrap extends LifeCycle with DataBaseSupport {

  override def init(context: ServletContext) {
    context.mount(new PostingRest, "/posts")
  }

  override def destroy(context: ServletContext) {
    super.destroy(context)
    closeDbConnection
  }
}
