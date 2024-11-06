/** ------------------------------------- */

var mysql = require('mysql');

var con = mysql.createConnection({
    host: "127.0.0.2",
    user: "root",
    password: ""
});

con.connect(function (err) {
    if (err) throw err;
    console.log("Connected!");
    con.query("create database weblab", function (err, result) {
        if (err) throw err;
        console.log("Database created");
        return;
    });
});

/** ------------------------------------- */

var mysql = require('mysql');

var con = mysql.createConnection({
    host: "127.0.0.2",
    user: "root",
    password: "",
    database: "weblab"
});

con.connect(function (err) {
    if (err) throw err;
    console.log("Connected!");
    var sql = "create table emp (empId varchar(255), firstName varchar(255), lastName varchar(255), departmentName varchar(255))";
    con.query(sql, function (err, result) {
        if (err) throw err;
        console.log("Table created");
    });
});

/** ------------------------------------- */

var mysql = require('mysql');

var con = mysql.createConnection({
    host: "127.0.0.2",
    user: "root",
    password: "",
    database: "weblab"
});

con.connect(function (err) {
    if (err) throw err;
    console.log("Connected!");
    var sql = "insert into emp (empId, firstName, lastName, departmentName) values ?";
    var values = [
        ['1', 'Ken', 'Sanchez', 'Executive'],
        ['2', 'Terri', 'Duffy', 'Engineering'],
        ['3', 'Roberto', 'Tamburello', 'Engineering'],
        ['4', 'Rob', 'Walters', 'Engineering'],
        ['5', 'Gail', 'Erickson', 'Engineering'],
        ['6', 'Jossef', 'Goldberg', 'Engineering'],
        ['7', 'Dylan', 'Miller', 'Support'],
        ['8', 'Diane', 'Margheim', 'Support'],
        ['9', 'Gibi', 'Matthew', 'Support'],
        ['10', 'Michael', 'Raheem', 'Support']
    ];
    con.query(sql, [values], function (err, result) {
        if (err) throw err;
        console.log("Number of records inserted: " + result.affectedRows);
    });
});

/** ------------------------------------- */

var mysql = require('mysql');

var con = mysql.createConnection({
    host: "127.0.0.2",
    user: "root",
    password: "",
    database: "weblab"
});

con.connect(function (err) {
    if (err) throw err;
    con.query("select * from emp WHERE departmentName = 'Engineering'", function (err, result) {
        if (err) throw err;
        console.log(result);
    });
});

/** ------------------------------------- */

var mysql = require('mysql');

var con = mysql.createConnection({
    host: "127.0.0.2",
    user: "root",
    password: "",
    database: "weblab"
});

con.connect(function (err) {
    if (err) throw err;
    var sql = "update emp set departmentName = 'Executive' where firstName = 'Terri'";
    con.query(sql, function (err, result) {
        if (err) throw err;
        console.log(result.affectedRows + " record(s) updated");
    });
});
