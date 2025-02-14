## `Entendimento sobre alguns pilares do POO:`
 # `Herança:`
  <br/>
  
 * A herança no Poo permite que uma classe herde métodos e atributos de uma classe super, porém ela pode causar muito acoplamento entre a superclasse 
  e as subclasses por causa de suas dependências, ou seja, alterar estruturas na superclasse pode causar uma quebra do código das subclasses,
  fazendo com o que o código ou o projeto não seja escalável.
   * A herança uso o princípio **"IS A" (é um)**, por exemplo, quando a classe cachorro herda da classe animal, ele é um animal.
  
   <br/>
   <br/> <br/>
  
  
 # `Composição:`
   <br/>

 *  A composição na orientação a objetos é onde uma classe contém uma ou mais instâncias de outras classes como parte de sua estrutura. Na estrutura da composição, você declara um objeto de outra classe como **ATRIBUTO** e posteriormente, quado criar um construtor você cria o **OBJETO** dessa classe dentro **do construtor**, o que garante que caso o objeto **"PAI"** seja excluído, seus **OBJETOS SECUNDÁRIOS** sejam excluídos também.
   *  Na composição, é utilizado o princípio **HAS-A** **(TEM UM)**, ou seja, o objeto pai tem dependências com um ou mais objetos filhos para exercer determinada função.
  
   ## `Exemplo de composição:`
    
* ```java
  import comportamentos.Andar;
  import comportamentos.Falar;
  import comportamentos.Respirar;

  public class Cavalo extends Animal {

    private Falar falar;
    private Respirar respirar;
    private Andar andar;

    public Cavalo(String nome, int idade, String categoria) {
        super(nome, idade, categoria);

        falar = new Falar();
        respirar = new Respirar();
        andar = new Andar();
    }

    public void falar() {
        this.falar.falar("relinxar");
    }
  } 

<br/>


  ### `Explicação:`
  * Para usar a composição, primeiro você declara o atributo na classe pai (o objeto pai). Essa variável será usada para armazenar a referência ao objeto filho, após isso, dentro do construtor da classe pai, você cria o objeto da classe filha. Isso é onde realmente o objeto filho é instanciado e a referência é atribuída à variável do objeto pai.
  
  
   <br/> <br/> <br/>
  
  
  
  # `Injeção de dependência:` 
   <br/>
    
     
  * No caso da injeção de dependência, você declara o   atributo como uma referência para a classe dependente (o objeto filho). Porém, não cria o objeto dentro da classe (**Diferente da composição, já que é criado o objeto na classe**). Ao invés disso, o objeto será passado de fora (por meio do construtor ou por um método setter). Dentro do construtor da classe pai, você não cria o objeto filho. Em vez disso, o objeto filho será passado como argumento para o construtor da classe pai.
  O construtor do pai vai receber o objeto e atribuir a variável do objeto pai com a instância passada. 
  - ### **De modo simples, na Injeção de Dependência (DI), você não cria os objetos dentro da classe pai. Você apenas declara a variável do tipo da dependência (como em composição), mas as instâncias dos objetos são passadas para a classe pai de fora, geralmente por meio do construtor ou por métodos setters.**


  ## `Exemplo de Injeção de Dependência:`
  <br/>
    
* ```java
    public class Cavalo extends Animal {

    private Falar falar;
    private Respirar respirar;
    private Andar andar;

    // o Construtor recebe as dependências de fora
    public Cavalo(String nome, int idade, String categoria, Falar falar, Respirar respirar, Andar andar) {
        super(nome, idade, categoria);
        this.falar = falar;  // A dependência também é passada de fora
        this.respirar = respirar;
        this.andar = andar;
    }

    public void falar() {
        this.falar.falar("relinxar");
    }
    
<br/><br/>

### `Explicação:`
  - Agora, o construtor do cavalo recebe as instâncias de falar, respirar e andar como parâmetros. Ou seja, não criamos mais o objeto dentro da classe **Cavalo**, eles são passados por fora.
  
   <br/> <br/>
  
## `Exemplo de uso:`

* ```java

  public class Main {
    public static void main(String[] args) {
        // Criando as dependências de fora
        Falar falar = new Falar();
        Respirar respirar = new Respirar();
        Andar andar = new Andar();

        // Passando as dependências para o construtor do Cavalo
        Cavalo cavalo = new Cavalo("Relincho", 5, "Equino", falar, respirar, andar);

        // O cavalo agora pode falar, pois recebeu a dependência de Falar
        cavalo.falar();  // O cavalo vai relinchar
    }
  }
## `Conclusão:`
- Na composição, o objeto não é passado pelo construtor. Em vez disso, ele é criado diretamente dentro da classe, o que resulta em um maior acoplamento, pois a classe depende diretamente da implementação e da criação do objeto dependente. O acoplamento é maior porque a classe não pode ser facilmente modificada para usar outra implementação ou instância, já que ela está fortemente ligada à criação do objeto dependente.

<br/>

- Na **Injeção de Dependência**, primeiramente cria apenas o atributo. Quando definimos esse atributo, nao criamos o objeto falar imediatamente, ele será criado ou atribuído posteriormente. Que é quando o construtor recebe as depêndencias de fora, e essa dependência é atribuída à variável (atributo). No final das contas, na DI, não criamos o objeto dentro da classe, ela é criada em outra classe e passada como parâmetro pelo construtor.

