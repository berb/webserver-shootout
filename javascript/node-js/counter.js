var http = require('http');

var i = 0;

http.createServer(function (req, res) {
  res.writeHead(200, {'Content-Type': 'text/plain'});
  res.end((++i)+'\n');
}).listen(8001);
