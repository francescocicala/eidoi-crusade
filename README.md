# Eidoi Crusade
A java-based two-players card game. You are a *Mage*, fighting against your rival for the Sacred Graal. You will lead your alliance of mythical heroes into a new legend!

### Game mechanics
The game is very simple. The first phase is called **Evocation**, and every Mage will select the heroes that will compose his alliance. The second phase is the **Crusade**, where the Mages will send their heroes into the battle. Your goal is to reduce the Health Points of the rival Mage to zero before he does the same with you!

#### Evocation Phase
The protagonists of this Crusade are the Eidoi, mythical heroes evoked from the legend. They are 10, and four of them will compose your alliance. They have a name, an attack value and a defense value. The Evocation Phase is formed by four drafts, where two heroes are randomly sampled. The two Mages will select their Eidos with alternated priority, until they will have formed their team. There will be no repetitions during the drafts, so that the 8 heroes in game will be unique.

#### Crusade Phase
The Crusade Phase is made up of battles, which will follow one another until one of the two Mages is defeated. Mages choose at the same time an Eidos from their alliance, together with an order. The chosen Eidos will be sent into the next battle with that order. Mages can choose one of two possible orders before each battle, after having selected the Eidos: 1) attack the rival Eidos; 2) attack the rival Mage.
For simplicity, let us consider that the two Mages, M1 and M2, have chosen respectively the Eidoi E1 and E2 for the next battle. We have the following cases:
1. E1 is attacking E2 and E2 is attacking E1: the attack values of the two Eidoi are compared. The Eidos with the lowest attack is sealed, i.e. it won't be part of the alliance anymore and won't be able to selected for the future battles. If there is a draw, both the Eidoi will be sealed.
2. E1 is attacking E2, and E2 is attacking M1: if E1's attack value is higher than E2's defense value, E2 will die and no damage is dealt to M1. If E1's attack value is equal or lower than E2's defense value, M1 will lose a number of Health Points equal to the attack value of E2.
3. E1 is attacking M2 and E2 is attacking M1: both Mages will lose Health Points equal to the attack value of the Eidos which is attacking them.

#### Win condition
If the HP of a Mage are zero or less, that Mage has been defeated and the other one wins the war for the Sacred Graal. A Mage is also defeated is he loses all of his Eidoi while the other Mage has at least one member in his alliance. If both the Mages lose all their Eidoi, the one with the higher number of Health Points wins, and if they have the same number of health points, it is a draw. 

