class Demo{
    private id: string;

    public constructor(id?: string) {
        this.id = id;
    }

    public foo(): boolean {
        console.log(this.id);
        return !this.id;
    }
}

var cc = new Demo();
console.log(cc.foo());

var dd = new Demo('111');
console.log(dd.foo());