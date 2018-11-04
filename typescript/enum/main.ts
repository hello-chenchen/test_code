enum EnumClass {
    One = 2,
    Two,
    Three
}

class UseEnum {
    arg: EnumClass;
}

let demo: UseEnum = new UseEnum();
demo.arg = EnumClass.Two;
console.log(demo.arg);