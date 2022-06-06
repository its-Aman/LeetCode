class TrieNode {
  public children: Map<string, TrieNode>;
  public value: number;

  constructor(value = 0) {
    this.children = new Map<string, TrieNode>();
    this.value = value;
  }
}

class MapSum {
    private root: TrieNode;
    private map: Map<string, number>;

    constructor() {
      this.root = new TrieNode();
      this.map = new Map<string, number>()
    }

    insert(key: string, val: number): void {
      const delta = val - (this.map.get(key) || 0);
      this.map.set(key, val);

      let curr = this.root;
      curr.value += delta;

      for(let c of key){
        if(!curr.children.has(c)){
          curr.children.set(c, new TrieNode());
        }
        curr = curr.children.get(c);
        curr.value += delta;
      }
    }

    sum(prefix: string): number {
      let curr = this.root;

      for(let c of prefix){
        if(!curr.children.has(c))
          return 0;
        curr = curr.children.get(c);
      }
      return curr.value;
    }
}