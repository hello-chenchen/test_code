var Demo = /** @class */ (function () {
    function Demo(id) {
        this.id = id;
    }
    Demo.prototype.foo = function () {
        console.log(this.id);
        return !this.id;
    };
    return Demo;
}());
var cc = new Demo();
console.log(cc.foo());
var dd = new Demo('111');
console.log(dd.foo());
