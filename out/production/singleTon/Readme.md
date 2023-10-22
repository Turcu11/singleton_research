# Singleton as a design pattern

#### Definitie: Singleton este un design pattern creational care se asigura ca un obiect poate avea doar o instanta

De ce am avea nevoie de un obiect sa fie restrans la o **singura instana** ?

Exista situatii in care nu are sens sa tot creem instante ale unui obiect ex:(date de conectare le DB)

Avantajul pe care il aduce Singleton-ul este acela al performantei aplicatiei, dat fiind ca nu se tot creeaza instante de obiecte ci se tot refera la un obiect creat deja
si este mai sigur, lucrurile sunt mai simple cand stii sigur ca ai doar o instanta al obiectului orice problema ai avea stii exact unde sa te uiti

**PRO/CON ->**

**>PRO:** face aplicatia mai simpla si mai sigura, nu permite sa sa instantieze obiecte aiurea, 
este mai putina complexitate

**>CON:** in cazul aplicatiilor multi-thread este nevoie de o optimizare speciala pentru a nu permite aplicatiei sa foloseasca un obiect care este partial creat, daca nu se ia 
in considerare aplicatia va da crash

**Caz special (problema multi-thread-ului si cum poate fi rezolvata):** dupa cum stim JVM permite folosirea mai multor fire de executie intr-un program java, 
daca presupnunem ca avem 2 fire de executie **A & B** primul care doreste o instanta al singleton-ului este firul A, care verifica existenta unei instante, 
aceasta lipseste si firul A incepe sa creeze singleton-ul, in momentul inceperii instantierii deja in memorie se considera ca instanta este deja creata (chiar daca doar partial)
astfel daca firul B doreste o instanta a singleton-ului, considera ca acesta este deja prezent in program si incearca sa returneze instanta care a fost creata de firul A, ceea ce nu
este posibil pentru ca este doar partial instantiata, asta rezulta intr-un crash al aplicatiei.

Pentru a ne asigura ca nu este cazul folosim keyword-ul **volatile** cand declaram instanta singleton-ului iar in acest fel JVM va sti sa interpreteze pentru multi-threading situatia descrisa mai sus.