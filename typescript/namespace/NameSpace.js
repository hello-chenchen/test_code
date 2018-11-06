var Demo;
(function (Demo) {
    var foo = /** @class */ (function () {
        function foo() {
        }
        foo.prototype.foo1 = function () {
            console.log("111");
        };
        return foo;
    }());
    Demo.foo = foo;
})(Demo || (Demo = {}));
var cc = new Demo.foo();
