'use strict';

var primes = [];
for(var i = 2; i <= 100; i++){
    var isPrime = true;
    for(var j = 2; j < i; j++){
        if (i % j == 0) {
            isPrime = false;
            break;
        }
    }
    if(isPrime){
        primes.push(i);
    }
}

var fs = require('fs');
var file = fs.createWriteStream('asal.txt');
file.on('error', function(err) { /* error handling */ });
primes.forEach(function(v) { file.write(String(v) + ' '); });
file.end()