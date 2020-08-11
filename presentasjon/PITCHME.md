---?image=flyt_monster_mork_bakgrunn.svg&size=120%
# Refaktorering

Note:
- Hva forbinder dere med refaktorering? (5 min)



--- 

### Kode

```
public class WhatWeWantToVerifyTest {

    @Test
    public void assumptionForTestAndExpectedOutcome() {
       //Given
       ThingToTest ttt = new ThingToTest();
       Result expected = new Result().withExpectedValues();

       //When
       Result result = ttt.methodToBeTested();

       //Then
       assertEquals(expectedValue, result);
    }
}
```


Note: 
- vis en test i kode -- forklar hva de ulike delene skal gjøre
- annotasjon: denne testen skal kjøres automatisk
- navn: forretningsforklaring! Dette er dokumentasjon. testnavn forklarer
  hvordan virker (spesifikke forretningsregler). Forklare hensikt
- Given: Hvordan ser verden ut når du starter testen? Også kalt precondition (arrange, precondition)
- When: Oppførselen du tester (act)
- Then: Verifisere at resultatet av det du har gjort gir korrekt resultat (assert, postcondition)

