var EnumClass;
(function (EnumClass) {
    EnumClass[EnumClass["One"] = 2] = "One";
    EnumClass[EnumClass["Two"] = 3] = "Two";
    EnumClass[EnumClass["Three"] = 4] = "Three";
})(EnumClass || (EnumClass = {}));
var UseEnum = /** @class */ (function () {
    function UseEnum() {
    }
    return UseEnum;
}());
var demo = new UseEnum();
demo.arg = EnumClass.Two;
console.log(demo.arg);
