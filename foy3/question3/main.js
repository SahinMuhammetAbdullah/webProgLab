'use strict';
const fs = require('fs');
var data = fs.readFileSync('asal_sayi.txt', 'utf-8');
var prime = (data.split(" ")).map(Number);
for (var i = 0; i <= 90; i++){
  if(i != prime[i]){
    for (var k = prime.length; k >= i; k--){
      prime[k] = prime[k-1];
    }
    prime[i] = i;
  }
}
var file = fs.createWriteStream('tum_sayilar.txt');
file.on('error', function(err) { /* error handling */ });
prime.forEach(function(v) { file.write(String(v) + ' '); });
file.end()