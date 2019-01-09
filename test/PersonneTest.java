import domaine.Personne;
import domaine.Sexe;
import domaine.TrancheAge;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class PersonneTest {

    List<Personne> listPersonne = new ArrayList();

    @Before
    public void initialisation(){
        System.out.println("Begin");
        listPersonne.add(new Personne("test1", "test1gmail.com",20, Sexe.M, "Célibataire"));
        listPersonne.add(new Personne("test2", "test2gmail.com",23, Sexe.M, "Célibataire"));
        listPersonne.add(new Personne("test3", "test3gmail.com",22, Sexe.F, "Marié"));
        listPersonne.add(new Personne("test4", "test4gmail.com",21, Sexe.F, "Célibataire"));
        listPersonne.add(new Personne("test5", "test5gmail.com",25, Sexe.M, "Célibataire"));
        listPersonne.add(new Personne("test6", "test6gmail.com",23, Sexe.F, "Marié"));
        listPersonne.add(new Personne("test7", "test7gmail.com",27, Sexe.M, "Célibataire"));
        listPersonne.add(new Personne("test8", "test8gmail.com",23, Sexe.M, "Célibataire"));
        listPersonne.add(new Personne("test9", "test9gmail.com",24, Sexe.F, "Marié"));
        listPersonne.add(new Personne("test10", "test10gmail.com",21, Sexe.F, "Célibataire"));
        listPersonne.add(new Personne("test10", "test10gmail.com",21, Sexe.F, "Célibataire"));
    }

    @Test
    public void remplissageList(){

        listPersonne.sort(null);

        for(int i = 0; i < listPersonne.size(); i++){
            System.out.println(listPersonne.get(i));
        }

    }

    @Test
    public void comparable(){

        Personne homme = new Personne("test1", "test1gmail.com",20, Sexe.M, "Célibataire");
        Personne homme2 = new Personne("test1", "test1gmail.com",23, Sexe.M, "Célibataire");
        Personne femme = new Personne("test1", "test1gmail.com",25, Sexe.F, "Célibataire");

        System.out.println(homme.compareTo(femme));
        System.out.println(femme.compareTo(homme));
        System.out.println(homme.compareTo(homme2));
    }

    @Test
    public void hashSet(){

        Set<Personne> setPersonnes = new HashSet();

        for(int i = 0; i < listPersonne.size(); i++){
            setPersonnes.add(listPersonne.get(i));
        }
        System.out.println(setPersonnes.size());
    }

    @Test
    public void map(){

        Map<String, Personne> mapPersonnes = new HashMap<>();

        for(Personne p : listPersonne){
            mapPersonnes.put(p.getEmail(), p);
        }
        System.out.println(mapPersonnes.size());
        System.out.println(mapPersonnes.get("test1gmail.com"));
    }

    @Test
    public void mapTrancheAge(){

        HashMap<TrancheAge, List<Personne>> mapPersonnes = new HashMap<>();

        mapPersonnes.put(TrancheAge.T1, new ArrayList());
        mapPersonnes.put(TrancheAge.T2, new ArrayList());
        mapPersonnes.put(TrancheAge.T3, new ArrayList());

        for(Personne p : listPersonne){
            List<Personne> list;
            if(p.getAge() <= 18){
                list = mapPersonnes.get(TrancheAge.T1);
            }else if(p.getAge() <= 65){
                list = mapPersonnes.get(TrancheAge.T2);
            }else{
                list = mapPersonnes.get(TrancheAge.T3);
            }
            list.add(p);
        }

        List<Personne> listPersonne = mapPersonnes.get(TrancheAge.T3);
        for(Personne p : listPersonne){
            System.out.println(p);
        }

    }

    @Test
    public void mapEtatCivil(){

        HashMap<String, List<Personne>> mapPersonnes = new HashMap<>();

        mapPersonnes.put("Célibataire", new ArrayList());
        mapPersonnes.put("Marié", new ArrayList());

        for(Personne p : listPersonne){
            List<Personne> list;
            if(p.getEtatCivil().equals("Célibataire")){
                list = mapPersonnes.get("Célibataire");
            }else{
                list = mapPersonnes.get("Marié");
            }
            list.add(p);
        }

        List<Personne> listPersonne = mapPersonnes.get("Marié");
        for(Personne p : listPersonne){
            System.out.println(p);
        }

    }
}
