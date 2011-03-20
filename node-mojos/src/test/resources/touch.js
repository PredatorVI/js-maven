/**
 * Created by .
 * User: btilford
 * Date: 3/19/11
 * Time: 9:12 PM
 * To change this template use File | Settings | File Templates.
 */
var sys = require('sys'),
    fs = require('fs'),
    path = '${project.build.outputDirectory}/created-by-nodejs',
    file = null,
    exitCode = 0


console.log("creating file")
file = fs.createWriteStream(path)
console.log("writing to file")
file.write("guess the test passed")
console.log("closing file")