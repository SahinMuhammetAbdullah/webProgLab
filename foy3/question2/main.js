'use strict';
const fs = require('fs');
var data = fs.readFileSync('quiz 6.txt', 'utf-8');
var line = data.split("\n");
for (var i = 0; i < line.length; i++) {
  var value = (line[i].split(",")).map(Number);
  var result = Math.pow(value[0], 2) * value[1] + value[0] * value[2] + value[3];
  console.log(result);
}