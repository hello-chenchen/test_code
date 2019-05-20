template<typename T>
struct Node {
    Node(T data) {
        _data = data;
    }
    T _data;
    Node* prev;
    Node* next;
};

template<typename T>
class ListIterator {
    public:
        typedef ListIterator<T> _Self;

    public:
        ListIterator() {}
        ListIterator(Node<T>* nodeData) {
            _M_node = nodeData;
        }
        ~ListIterator() {}

    public:
        Node<T>* _M_node;
};

template<typename T>
class classA {
    public:
        // typedef ListIterator<T> iterator;

    public:
        classA(Node<T>* ccc) {
            c = ccc;
        }

        T foo() {
            return c->_data;
        }

        ListIterator<T> begin() {
            return ListIterator<T>((Node<T>*)c->next);
        }

        void pop_back() {
            ListIterator<T> aa = ListIterator<T>(c->next);
            erase(aa);
        }

        ListIterator<T> erase(ListIterator<T> itr) {
            return itr;
        }

        // void foo1(int a) {
        //     c = a;
        // }

    private:
        Node<T>* c;
};