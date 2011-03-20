package js.maven.node

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.Spec
import java.io.File
import io.Source
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith

/**
 *
 *
 * @author btilford
 *
 * <em>Created</em> 3/19/11 9:07 PM
 * @since 1.0
 */

@RunWith(classOf[JUnitRunner])
class NodeRunnerSpec extends Spec with ShouldMatchers {

  describe("node.js") {
    describe("(when ran)")  {
      it("node should print out executed") {

        val url = getClass.getResource("/server.js")
        assert(url != null, "Bad url")

        val file = new File(url.getPath)
        assert(file.exists, "File " + file.getAbsolutePath + "  doesn't exist!")

        NodeRunner.run(file.getAbsolutePath)  {process:Process =>
          var found = false
          for (line <- Source.fromInputStream(process.getInputStream,"UTF-8").getLines) {
            println("line: " + line)
            if(line.trim == "executed") {found = true}
          }
          found should be (true)
        }
      }
    }
  }
}