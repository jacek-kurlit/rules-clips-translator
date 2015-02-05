(deffacts initial-facts
  (Client (Name "KKR") (Age 19) (Gender male) (MaritalStatus married) (UsState NY) (Type elite preffered) (DuI false) (NoA 2) (NoMV 2) (SoTC none))
  (Car (Owner "KKR") (Name "VW Golf IV") (Convertible false) (Year 2011) (Price 30000) (HasAlarm true) (HasRollBar false) (IsOnHTPA true) (Style compact) (AirBags driver passenger))
  (Insurance (Client "KKR") (UninsuredDriver false) (MedicalCoverage false))

  (Client (Name "KKR") (Age 29) (Gender male) (MaritalStatus married) (UsState NY) (Type elite preffered) (DuI false) (NoA 0) (NoMV 2) (SoTC none))
  (Car (Owner "KKR") (Name "VW Golf IV") (Convertible false) (Year 2011) (Price 30000) (HasAlarm true) (HasRollBar false) (IsOnHTPA true) (Style compact) (AirBags driver passenger))
  (Insurance (Client "KKR") (UninsuredDriver false) (MedicalCoverage false))
)

(defglobal ?*year* = 2013)

(deftemplate Client
  (slot Name
    (type STRING)
  )
  (slot Age
    (type INTEGER)
    (range 0 120)
  )
  (slot Gender
    (type SYMBOL)
    (allowed-symbols male female)
  )
  (slot MaritalStatus
    (type SYMBOL)
    (allowed-symbols single married)
  )
  (slot UsState
    (type SYMBOL)
  )
  (multislot Type
    (type SYMBOL)
    (allowed-symbols preffered elite longTerm)
  )
  (slot DuI
    (type SYMBOL)
    (allowed-symbols false true)
  )
  (slot NoA
    (type INTEGER)
    (range 0 10000)
  )
  (slot NoMV
    (type INTEGER)
    (range 0 10000)
  )
  (slot SoTC
    (type SYMBOL)
    (allowed-symbols none school licensedDriver seniorRefresherCourse)
  )
)

(deftemplate ClientFacts
  (slot Name
    (type STRING)
  )
  (slot Type
    (type SYMBOL)
    (allowed-symbols young typical senior)
    (default typical)
  )
  (slot IsHRD
    (type SYMBOL)
    (allowed-symbols false true)
    (default false)
  )
  (slot Eligible
    (type SYMBOL)
    (allowed-symbols false true)
    (default false)
  )
  (slot HasTC
    (type SYMBOL)
    (allowed-symbols false true)
    (default false)
  )
)

(deftemplate Car
  (slot Owner
    (type STRING)
  )
  (slot Name
    (type STRING)
  )
  (slot Convertible
    (type SYMBOL)
    (allowed-symbols false true)
  )
  (slot Year
    (type INTEGER)
    (range 1900 2100)
  )
  (slot Price
    (type NUMBER)
  )
  (slot HasAlarm
    (type SYMBOL)
    (allowed-symbols false true)
  )
  (slot HasRollBar
    (type SYMBOL)
    (allowed-symbols false true)
  )
  (slot IsOnHTPA
    (type SYMBOL)
    (allowed-symbols false true)
  )
  (slot Style
    (type SYMBOL)
    (allowed-symbols compact sedan luxury)
  )
  (multislot AirBags
    (type SYMBOL)
    (allowed-symbols driver passenger side)
  )
)

(deftemplate CarFacts
  (slot Owner
    (type STRING)
  )
  (slot Name
    (type STRING)
  )
  (slot BasePremium
    (type NUMBER)
  )
  (slot Eligible
    (type SYMBOL)
    (allowed-symbols notEligible provisional eligible)
    (default eligible)
  )
  (slot POIR
    (type SYMBOL)
    (allowed-symbols low moderate high extremelyHigh)
    (default extremelyHigh)
  )
  (slot PTR
    (type SYMBOL)
    (allowed-symbols low moderate high)
  )
)

(deftemplate EligibilityScore
  (slot Name
    (type STRING)
  )
  (slot DisplayName
    (type STRING)
  )
  (slot Score
    (type NUMBER)
  )
  (slot Reason
    (type STRING)
  )
  (slot Type
    (type SYMBOL)
    (allowed-symbols partial total)
  )
)

(deftemplate EligibilityDecision
  (slot Name
    (type STRING)
  )
  (slot Decision
    (type SYMBOL)
    (allowed-symbols notEligible review eligible)
  )
)

(deftemplate CarPremium
  (slot Owner
    (type STRING)
  )
  (slot Name
    (type STRING)
  )
  (slot Premium
    (type NUMBER)
  )
  (slot Reason
    (type STRING)
  )
  (slot Type
    (type SYMBOL)
    (allowed-symbols partial total)
  )
)

(deftemplate DriverPremium
  (slot Name
    (type STRING)
  )
  (slot Premium
    (type NUMBER)
  )
  (slot Reason
    (type STRING)
  )
  (slot Type
    (type SYMBOL)
    (allowed-symbols partial total)
  )
)

(deftemplate CarDiscount
  (slot Owner
    (type STRING)
  )
  (slot Name
    (type STRING)
  )
  (slot Discount
    (type NUMBER)
  )
  (slot Reason
    (type STRING)
  )
  (slot Type
    (type SYMBOL)
    (allowed-symbols partial total)
  )
)

(deftemplate MarketSegmentDiscount
  (slot Name
    (type STRING)
  )
  (slot Discount
    (type NUMBER)
  )
  (slot Reason
    (type STRING)
  )
  (slot Type
    (type SYMBOL)
    (allowed-symbols partial total)
  )
)

(deftemplate Insurance
  (slot Client
    (type STRING)
  )
  (slot UninsuredDriver
    (type SYMBOL)
    (allowed-symbols false true)
  )
  (slot MedicalCoverage
    (type SYMBOL)
    (allowed-symbols false true)
  )
  (slot Premium
    (type NUMBER)
    (default 0)
  )
)


(defmodule MAIN (export deftemplate ?ALL) (export defglobal ?ALL))
(defmodule automobile-eligibility-potential-theft (import MAIN deftemplate ?ALL))
(defmodule automobile-eligibility-potential-occupant-injury (import MAIN deftemplate ?ALL))
(defmodule automobile-eligibility-calculation (import MAIN deftemplate ?ALL))
(defmodule driver-eligibility-driver-age (import MAIN deftemplate ?ALL))
(defmodule driver-eligibility-driver-certification (import MAIN deftemplate ?ALL))
(defmodule driver-eligibility-driver-records (import MAIN deftemplate ?ALL))
(defmodule driver-eligibility-calculation (import MAIN deftemplate ?ALL))
(defmodule eligibility-scoring (import MAIN deftemplate ?ALL))
(defmodule car-base-premiums (import MAIN deftemplate ?ALL))
(defmodule car-premiums (import MAIN deftemplate ?ALL) (import MAIN defglobal ?ALL))
(defmodule driver-premiums (import MAIN deftemplate ?ALL))
(defmodule car-discounts (import MAIN deftemplate ?ALL))
(defmodule market-segment-discounts (import MAIN deftemplate ?ALL))

(defrule automobile-eligibility-potential-theft::initial
  (Car (Owner ?Owner) (Name ?Name))
  (not (CarFacts (Owner ?Owner) (Name ?Name)))
=>
  (assert (CarFacts (Owner ?Owner) (Name ?Name)))
)

(defrule automobile-eligibility-potential-theft::PTR-high1
  (Car (Owner ?Owner) (Name ?Name) (Convertible true))
  ?CarFacts <- (CarFacts (Owner ?Owner) (Name ?Name))
=>
  (modify ?CarFacts (PTR high))
  (printout t "automobile-eligibility-potential-theft::PTR-high1: Setting of Potencial Theft Rating to HIGH for " ?Owner " -> " ?Name crlf)
  (pop-focus)
)

(defrule automobile-eligibility-potential-theft::PTR-high2
  (Car (Owner ?Owner) (Name ?Name) (Price ?Price & :(> ?Price 45000)))
  ?CarFacts <- (CarFacts (Owner ?Owner) (Name ?Name))
=>
  (modify ?CarFacts (PTR high))
  (printout t "automobile-eligibility-potential-theft::PTR-high2: Setting of Potencial Theft Rating to HIGH for " ?Owner " -> " ?Name crlf)
  (pop-focus)
)

(defrule automobile-eligibility-potential-theft::PTR-high3
  (Car (Owner ?Owner) (Name ?Name) (IsOnHTPA true))
  ?CarFacts <- (CarFacts (Owner ?Owner) (Name ?Name))
=>
  (modify ?CarFacts (PTR high))
  (printout t "automobile-eligibility-potential-theft::PTR-high3: Setting of Potencial Theft Rating to HIGH for " ?Owner " -> " ?Name crlf)
  (pop-focus)
)

(defrule automobile-eligibility-potential-theft::PTR-moderate
  (Car (Owner ?Owner) (Name ?Name) (Price ?Price & :(>= ?Price 20000) & :(<= ?Price 45000)) (IsOnHTPA false))
  ?CarFacts <- (CarFacts (Owner ?Owner) (Name ?Name))
=>
  (modify ?CarFacts (PTR moderate))
  (printout t "automobile-eligibility-potential-theft::PTR-moderate: Setting of Potencial Theft Rating to MODERATE for " ?Owner " -> " ?Name crlf)
  (pop-focus)
)

(defrule automobile-eligibility-potential-theft::PTR-low
  (Car (Owner ?Owner) (Name ?Name) (Price ?Price & :(< ?Price 20000)) (IsOnHTPA false))
  ?CarFacts <- (CarFacts (Owner ?Owner) (Name ?Name))
=>
  (modify ?CarFacts (PTR low))
  (printout t "automobile-eligibility-potential-theft::PTR-low: Setting of Potencial Theft Rating to LOW for " ?Owner " -> " ?Name crlf)
  (pop-focus)
)


(defrule automobile-eligibility-potential-occupant-injury::POIR-exhigh1
  (Car (Owner ?Owner) (Name ?Name) (AirBags $?AirBags & :(eq (length$ ?AirBags) 0)))
  ?CarFacts <- (CarFacts (Owner ?Owner) (Name ?Name))
=>
  (modify ?CarFacts (POIR extremelyHigh))
  (printout t "automobile-eligibility-potential-occupant-injury::POIR-exhigh1: Setting of Potencial Occupant Injury Rating to EXTREMELY HIGH for " ?Owner " -> " ?Name crlf)
  (pop-focus)
)

(defrule automobile-eligibility-potential-occupant-injury::POIR-exhigh2
(declare (salience 1))
  (Car (Owner ?Owner) (Name ?Name) (Convertible true) (HasRollBar false))
  ?CarFacts <- (CarFacts (Owner ?Owner) (Name ?Name))
=>
  (modify ?CarFacts (POIR extremelyHigh))
  (printout t "automobile-eligibility-potential-occupant-injury::POIR-exhigh2: Setting of Potencial Occupant Injury Rating to EXTREMELY HIGH for " ?Owner " -> " ?Name crlf)
  (pop-focus)
)

(defrule automobile-eligibility-potential-occupant-injury::POIR-high
  (Car (Owner ?Owner) (Name ?Name) (AirBags $?AirBags & :(subsetp ?AirBags (create$ driver)) & :(eq (length$ ?AirBags) 1)))
  ?CarFacts <- (CarFacts (Owner ?Owner) (Name ?Name))
=>
  (modify ?CarFacts (POIR high))
  (printout t "automobile-eligibility-potential-occupant-injury::POIR-high: Setting of Potencial Occupant Injury Rating to HIGH for " ?Owner " -> " ?Name crlf)
  (pop-focus)
)

(defrule automobile-eligibility-potential-occupant-injury::POIR-moderate
  (Car (Owner ?Owner) (Name ?Name) (AirBags $?AirBags & :(subsetp ?AirBags (create$ driver passenger)) & :(eq (length$ ?AirBags) 2)))
  ?CarFacts <- (CarFacts (Owner ?Owner) (Name ?Name))
=>
  (modify ?CarFacts (POIR moderate))
  (printout t "automobile-eligibility-potential-occupant-injury::POIR-moderate: Setting of Potencial Occupant Injury Rating to MODERATE for " ?Owner " -> " ?Name crlf)
  (pop-focus)
)

(defrule automobile-eligibility-potential-occupant-injury::POIR-low
  (Car (Owner ?Owner) (Name ?Name) (AirBags $?AirBags & :(subsetp ?AirBags (create$ driver passenger side)) & :(eq (length$ ?AirBags) 3)))
  ?CarFacts <- (CarFacts (Owner ?Owner) (Name ?Name))
=>
  (modify ?CarFacts (POIR low))
  (printout t "automobile-eligibility-potential-occupant-injury::POIR-low: Setting of Potencial Occupant Injury Rating to LOW for " ?Owner " -> " ?Name crlf)
  (pop-focus)
)


(defrule automobile-eligibility-calculation::not-eligible
  (declare (salience 2))
  ?CarFacts <- (CarFacts (Owner ?Owner) (Name ?Name) (POIR extremelyHigh))
=>
  (modify ?CarFacts (Eligible notEligible))
  (printout t "automobile-eligibility-calculation::not-eligible: The car " ?Name " of " ?Owner " is NOT ELIGIBLE" crlf)
  (pop-focus)
)

(defrule automobile-eligibility-calculation::provisional1
  (declare (salience 1))
  ?CarFacts <- (CarFacts (Owner ?Owner) (Name ?Name) (POIR high))
=>
  (modify ?CarFacts (Eligible provisional))
  (printout t "automobile-eligibility-calculation::provisional1: The car " ?Name " of " ?Owner " is PROVISIONALLY ELIGIBLE" crlf)
  (pop-focus)
)

(defrule automobile-eligibility-calculation::provisional2
  (declare (salience 1))
  ?CarFacts <- (CarFacts (Owner ?Owner) (Name ?Name) (PTR high))
=>
  (modify ?CarFacts (Eligible provisional))
  (printout t "automobile-eligibility-calculation::provisional2: The car " ?Name " of " ?Owner " is PROVISIONALLY ELIGIBLE" crlf)
  (pop-focus)
)

(defrule automobile-eligibility-calculation::eligible
  ?CarFacts <- (CarFacts (Owner ?Owner) (Name ?Name))
=>
  (modify ?CarFacts (Eligible eligible))
  (printout t "automobile-eligibility-calculation::eligible: The car " ?Name " of " ?Owner " is ELIGIBLE" crlf)
  (pop-focus)
)

(defrule driver-eligibility-driver-age::initial
  (Client (Name ?Name))
  (not (ClientFacts (Name ?Name)))
=>
  (assert (ClientFacts (Name ?Name)))
)

(defrule driver-eligibility-driver-age::young-driver1
  (Client (Name ?Name) (Gender male) (Age ?Age & :(< ?Age 25)))
  ?ClientFacts <- (ClientFacts (Name ?Name))
=>
  (modify ?ClientFacts (Type young))
  (printout t "driver-eligibility-driver-age::young-driver1: Setting " ?Name " driver as YOUNG DRIVER" crlf)
  (pop-focus)
)

(defrule driver-eligibility-driver-age::young-driver2
  (Client (Name ?Name) (Gender female) (Age ?Age & :(< ?Age 20)))
  ?ClientFacts <- (ClientFacts (Name ?Name))
=>
  (modify ?ClientFacts (Type young))
  (printout t "driver-eligibility-driver-age::young-driver2: Setting " ?Name " driver as YOUNG DRIVER" crlf)
  (pop-focus)
)

(defrule driver-eligibility-driver-age::senior-driver
  (Client (Name ?Name) (Age ?Age & :(> ?Age 70)))
  ?ClientFacts <- (ClientFacts (Name ?Name))
=>
  (modify ?ClientFacts (Type senior))
  (printout t "driver-eligibility-driver-age::senior-driver: Setting " ?Name " driver as SENIOR DRIVER" crlf)
  (pop-focus)
)

(defrule driver-eligibility-driver-certification::has-certificate1
  (Client (Name ?Name) (SoTC school))
  ?ClientFacts <- (ClientFacts (Name ?Name))
=>
  (modify ?ClientFacts (HasTC true))
  (printout t "driver-eligibility-driver-certification::has-certificate1: The driver " ?Name " HAS TRAINIG CERTFICATION" crlf)
  (pop-focus)
)

(defrule driver-eligibility-driver-certification::has-certificate2
  (Client (Name ?Name) (SoTC licensedDriver))
  ?ClientFacts <- (ClientFacts (Name ?Name))
=>
  (modify ?ClientFacts (HasTC true))
  (printout t "driver-eligibility-driver-certification::has-certificate2: The driver " ?Name " HAS TRAINIG CERTFICATION" crlf)
  (pop-focus)
)

(defrule driver-eligibility-driver-certification::has-certificate3
  (Client (Name ?Name) (SoTC seniorRefresherCourse))
  ?ClientFacts <- (ClientFacts (Name ?Name))
=>
  (modify ?ClientFacts (HasTC true))
  (printout t "driver-eligibility-driver-certification::has-certificate3: The driver " ?Name " HAS TRAINIG CERTFICATION" crlf)
  (pop-focus)
)

(defrule driver-eligibility-driver-certification::has-not-certificate
  (Client (Name ?Name) (SoTC ?SoTC & ~:(member$ ?SoTC (create$ school licensedDriver seniorRefresherCourse))))
  ?ClientFacts <- (ClientFacts (Name ?Name))
=>
  (modify ?ClientFacts (HasTC false))
  (printout t "driver-eligibility-driver-certification::has-not-certificate: The driver " ?Name " HAS NOT TRAINIG CERTFICATION" crlf)
  (pop-focus)
)

(defrule driver-eligibility-driver-records::high-risk-driver1
  (Client (Name ?Name) (DuI true))
  ?ClientFacts <- (ClientFacts (Name ?Name))
=>
  (modify ?ClientFacts (IsHRD true))
  (printout t "driver-eligibility-driver-records::high-risk-driver1: The driver " ?Name " is HIGH RISK DRIVER" crlf)
  (pop-focus)
)

(defrule driver-eligibility-driver-records::high-risk-driver2
  (Client (Name ?Name) (NoA ?NoA & :(> ?NoA 2)))
  ?ClientFacts <- (ClientFacts (Name ?Name))
=>
  (modify ?ClientFacts (IsHRD true))
  (printout t "driver-eligibility-driver-records::high-risk-driver2: The driver " ?Name " is HIGH RISK DRIVER" crlf)
  (pop-focus)
)

(defrule driver-eligibility-driver-records::high-risk-driver3
  (Client (Name ?Name) (NoMV ?NoMV & :(> ?NoMV 3)))
  ?ClientFacts <- (ClientFacts (Name ?Name))
=>
  (modify ?ClientFacts (IsHRD true))
  (printout t "driver-eligibility-driver-records::high-risk-driver3: The driver " ?Name " is HIGH RISK DRIVER" crlf)
  (pop-focus)
)

(defrule driver-eligibility-calculation::eligible1
  ?ClientFacts <- (ClientFacts (Name ?Name) (Type young) (HasTC true))
=>
  (modify ?ClientFacts (Eligible true))
  (printout t "driver-eligibility-calculation::eligible1: The driver " ?Name " is ELIGIBLE" crlf)
  (pop-focus)
)

(defrule driver-eligibility-calculation::eligible2
  ?ClientFacts <- (ClientFacts (Name ?Name) (Type senior) (HasTC true))
=>
  (modify ?ClientFacts (Eligible true))
  (printout t "driver-eligibility-calculation::eligible2: The driver " ?Name " is ELIGIBLE" crlf)
  (pop-focus)
)

(defrule driver-eligibility-calculation::eligible3
  ?ClientFacts <- (ClientFacts (Name ?Name) (Type ~young & ~senior))
=>
  (modify ?ClientFacts (Eligible true))
  (printout t "driver-eligibility-calculation::eligible3: The driver " ?Name " is ELIGIBLE" crlf)
  (pop-focus)
)

(defrule driver-eligibility-calculation::not-eligible
  ?ClientFacts <- (ClientFacts (Name ?Name) (Type young | senior) (HasTC false))
=>
  (modify ?ClientFacts (Eligible false))
  (printout t "driver-eligibility-calculation::not-eligible: The driver " ?Name " is NOT ELIGIBLE" crlf)
  (pop-focus)
)


(defrule eligibility-scoring::car-eligibility1
  (CarFacts (Owner ?Owner) (Name ?Name) (Eligible notEligible))
=>
  (assert (EligibilityScore (Name ?Owner) (DisplayName (str-cat ?Owner "'s " ?Name)) (Score 100) (Reason "The car is not eligible") (Type partial)))
)

(defrule eligibility-scoring::car-eligibility2
  (CarFacts (Owner ?Owner) (Name ?Name) (Eligible provisional))
=>
  (assert (EligibilityScore (Name ?Owner) (DisplayName (str-cat ?Owner "'s " ?Name)) (Score 50) (Reason "The car is provisionally eligible") (Type partial)))
)

(defrule eligibility-scoring::car-eligibility3
  (CarFacts (Owner ?Owner) (Name ?Name) (Eligible eligible))
=>
  (assert (EligibilityScore (Name ?Owner) (DisplayName (str-cat ?Owner "'s " ?Name)) (Score 0) (Reason "The car is eligible") (Type partial)))
)

(defrule eligibility-scoring::driver-eligibility1
  (ClientFacts (Name ?Name) (Type young) (Eligible false))
=>
  (assert (EligibilityScore (Name ?Name) (DisplayName ?Name) (Score 30) (Reason "The young driver that is not eligible") (Type partial)))
)

(defrule eligibility-scoring::driver-eligibility2
  (ClientFacts (Name ?Name) (Type senior) (Eligible false))
=>
  (assert (EligibilityScore (Name ?Name) (DisplayName ?Name) (Score 20) (Reason "The senior driver that is not eligible") (Type partial)))
)

(defrule eligibility-scoring::driver-eligibility3
  (ClientFacts (Name ?Name) (Eligible true))
=>
  (assert (EligibilityScore (Name ?Name) (DisplayName ?Name) (Score 0) (Reason "The driver is eligible") (Type partial)))
)

(defrule eligibility-scoring::driver-hrd
  (ClientFacts (Name ?Name) (IsHRD true))
=>
  (assert (EligibilityScore (Name ?Name) (DisplayName ?Name) (Score 100) (Reason "The driver is high risk driver") (Type partial)))
)

(defrule eligibility-scoring::client-preffered
  (Client (Name ?Name) (Type $? preffered $?))
=>
  (assert (EligibilityScore (Name ?Name) (DisplayName ?Name) (Score -50) (Reason "The driver is preffered client") (Type partial)))
)

(defrule eligibility-scoring::client-elite
  (Client (Name ?Name) (Type $? elite $?))
=>
  (assert (EligibilityScore (Name ?Name) (DisplayName ?Name) (Score -100) (Reason "The driver is elite client") (Type partial)))
)

(defrule eligibility-scoring::create-initial-sum-of-scoring
  (EligibilityScore (Name ?Name) (Type partial))
  (not (EligibilityScore (Name ?Name) (Type total)))
=>
  (assert (EligibilityScore (Name ?Name) (Score 0) (Type total)))
  (printout t "eligibility-scoring::create-initial-sum-of-scoring: Adding initial element for eligibility sum for client " ?Name crlf)
)

(defrule eligibility-scoring::sum-and-display-scoring
  ?EligibilityScore <- (EligibilityScore (Name ?Name) (DisplayName ?DisplayName) (Score ?Score) (Reason ?Reason) (Type partial))
  ?ToalEligibilityScores <- (EligibilityScore (Name ?Name) (Score ?TotalScores) (Type total))
=>
  (modify ?ToalEligibilityScores (Score (+ ?TotalScores ?Score)))
  (retract ?EligibilityScore)
  (printout t "eligibility-scoring::sum-and-display-scoring: Eligibility Score for " ?DisplayName ": " ?Score " Reason: " ?Reason crlf)
)

(defrule eligibility-scoring::summary
(declare (salience -1))
  (EligibilityScore (Name ?Name) (Score ?TotalScore) (Type total))
  (not (EligibilityScore (Name ?Name) (Type partial)))
=>
  (assert (EligibilityDecision (Name ?Name)))
  (printout t "eligibility-scoring::summary: ########### The TOTAL eligibility scores for " ?Name " is " ?TotalScore " ###########" crlf)
)

(defrule  eligibility-scoring::decision-eligible1
  (EligibilityScore (Name ?Name) (Score ?TotalScore & :(< ?TotalScore 100)) (Type total))
  ?Decision <- (EligibilityDecision (Name ?Name))
=>
  (modify ?Decision (Decision eligible))
  (printout t "eligibility-scoring::decision-eligible1: Client " ?Name " IS ELIGIBLE for insurance" crlf crlf)
  (pop-focus)
)

(defrule  eligibility-scoring::decision-eligible2
  (declare (salience 1))
  (Client (Type longTerm))
  (EligibilityScore (Name ?Name) (Type total))
  ?Decision <- (EligibilityDecision (Name ?Name))
=>
  (modify ?Decision (Decision eligible))
  (printout t "eligibility-scoring::decision-eligible2: Client " ?Name " IS ELIGIBLE for insurance" crlf crlf)
  (pop-focus)
)

(defrule  eligibility-scoring::decision-review
  (EligibilityScore (Name ?Name) (Score ?TotalScore & :(>= ?TotalScore 100) & :(<= ?TotalScore 250)) (Type total))
  ?Decision <- (EligibilityDecision (Name ?Name))
=>
  (modify ?Decision (Decision review))
  (printout t "eligibility-scoring::decision-review: Client " ?Name " must be REVIEWED" crlf crlf)
  (pop-focus)
)

(defrule  eligibility-scoring::decision-not-eligible
  (EligibilityScore (Name ?Name) (Score ?TotalScore & :(> ?TotalScore 250)) (Type total))
  ?Decision <- (EligibilityDecision (Name ?Name))
=>
  (modify ?Decision (Decision notEligible))
  (printout t "eligibility-scoring::decision-not-eligible: Client " ?Name " IS NOT ELIGIBLE for insurance" crlf crlf)
  (pop-focus)
)

(defrule car-base-premiums::base-premium-car-compact
  (EligibilityDecision (Name ?Driver) (Decision eligible))
  (Car (Owner ?Driver) (Name ?CarName) (Style compact))
  ?CarFacts <- (CarFacts (Owner ?Driver) (Name ?CarName))
=>
  (modify ?CarFacts (BasePremium 250))
  (printout t "car-base-premiums::base-premium-car-compact: Setting BASE PREMIUM for " ?Driver "'s " ?CarName " to 250$" crlf)
  (pop-focus)
)

(defrule car-base-premiums::base-premium-car-sedan
  (EligibilityDecision (Name ?Driver) (Decision eligible))
  (Car (Owner ?Driver) (Name ?CarName) (Style sedan))
  ?CarFacts <- (CarFacts (Owner ?Driver) (Name ?CarName))
=>
  (modify ?CarFacts (BasePremium 400))
  (printout t "car-base-premiums::base-premium-car-sedan: Setting BASE PREMIUM for " ?Driver "'s " ?CarName " to 400$" crlf)
  (pop-focus)
)

(defrule car-base-premiums::base-premium-car-luxury
  (EligibilityDecision (Name ?Driver) (Decision eligible))
  (Car (Owner ?Driver) (Name ?CarName) (Style luxury))
  ?CarFacts <- (CarFacts (Owner ?Driver) (Name ?CarName))
=>
  (modify ?CarFacts (BasePremium 500))
  (printout t "car-base-premiums::base-premium-car-luxury: Setting BASE PREMIUM for " ?Driver "'s " ?CarName " to 500$" crlf)
  (pop-focus)
)

(defrule car-premiums::increase-new-car
  (EligibilityDecision (Name ?Driver) (Decision eligible))
  (Car (Owner ?Driver) (Name ?Name) (Year ?Year & :(<= (- ?*year* ?Year) 0)))
=>
  (assert (CarPremium (Owner ?Driver) (Name ?Name) (Premium 400) (Reason "The car is new") (Type partial)))
)

(defrule car-premiums::increase-5-years-old
  (EligibilityDecision (Name ?Driver) (Decision eligible))
  (Car (Owner ?Driver) (Name ?Name) (Year ?Year & :(> (- ?*year* ?Year) 0) & :(< (- ?*year* ?Year) 5)))
=>
  (assert (CarPremium (Owner ?Driver) (Name ?Name) (Premium 300) (Reason "The car is younger than 5 year old") (Type partial)))
)

(defrule car-premiums::increase-car-between-5-and-10
  (EligibilityDecision (Name ?Driver) (Decision eligible))
  (Car (Owner ?Driver) (Name ?Name) (Year ?Year & :(>= (- ?*year* ?Year) 5) & :(<= (- ?*year* ?Year) 10)))
=>
  (assert (CarPremium (Owner ?Driver) (Name ?Name) (Premium 250) (Reason "The car age is between 5 and 10 years") (Type partial)))
)

(defrule car-premiums::increase-uninsured-driver
  (EligibilityDecision (Name ?Driver) (Decision eligible))
  (Car (Owner ?Driver) (Name ?Name))
  (Insurance (Client ?Driver) (UninsuredDriver true))
=>
  (assert (CarPremium (Owner ?Driver) (Name ?Name) (Premium 300) (Reason "The insurance include uninsured driver") (Type partial)))
)

(defrule car-premiums::increase-medial-coverage
  (EligibilityDecision (Name ?Driver) (Decision eligible))
  (Car (Owner ?Driver) (Name ?Name))
  (Insurance (Client ?Driver) (MedicalCoverage true))
=>
  (assert (CarPremium (Owner ?Driver) (Name ?Name) (Premium 600) (Reason "The insurance include medical coverage") (Type partial)))
)

(defrule car-premiums::increase-poir-exhigh
  (EligibilityDecision (Name ?Driver) (Decision eligible))
  (CarFacts (Owner ?Driver) (Name ?Name) (POIR extremelyHigh))
=>
  (assert (CarPremium (Owner ?Driver) (Name ?Name) (Premium 1000) (Reason "The potencial occupant injury rating is extremely high") (Type partial)))
)

(defrule car-premiums::increase-poir-high
  (EligibilityDecision (Name ?Driver) (Decision eligible))
  (CarFacts (Owner ?Driver) (Name ?Name) (POIR high))
=>
  (assert (CarPremium (Owner ?Driver) (Name ?Name) (Premium 500) (Reason "The potencial occupant injury rating is high") (Type partial)))
)

(defrule car-premiums::increase-ptr-high
  (EligibilityDecision (Name ?Driver) (Decision eligible))
  (CarFacts (Owner ?Driver) (Name ?Name) (PTR high))
=>
  (assert (CarPremium (Owner ?Driver) (Name ?Name) (Premium 500) (Reason "The potencial theft rating is high") (Type partial)))
)

(defrule car-premiums::create-initial-sum-of-car-premiums
  (CarPremium (Owner ?Driver) (Name ?Name) (Type partial))
  (not (CarPremium (Owner ?Driver) (Name ?Name) (Type total)))
=>
  (assert (CarPremium (Owner ?Driver) (Name ?Name) (Premium 0) (Type total)))
  (printout t "car-premiums::create-initial-sum-of-car-premiums: Adding initial element for sum of car premiums for " ?Driver "'s " ?Name crlf)
)

(defrule car-premiums::sum-and-display-car-premiums
  ?CarPremium <- (CarPremium (Owner ?Driver) (Name ?CarName) (Premium ?Premium) (Reason ?Reason) (Type partial))
  ?ToalCarPremiums <- (CarPremium (Owner ?Driver) (Name ?CarName) (Premium ?TotalPremium) (Type total))
=>
  (modify ?ToalCarPremiums (Premium (+ ?TotalPremium ?Premium)))
  (retract ?CarPremium)
  (printout t "car-premiums::sum-and-display-car-premiums: Car Premium for " ?Driver "'s " ?CarName ": " ?Premium "$ Reason: " ?Reason crlf)
)


(defrule driver-premiums::increase-young-and-married-driver1
  (EligibilityDecision (Name ?Name) (Decision eligible))
  (Client (Name ?Name) (MaritalStatus married) (UsState ?UsState & :(member$ ?UsState (create$ CA NY VA))))
  (ClientFacts (Name ?Name) (Type young))
=>
  (assert (DriverPremium (Name ?Name) (Premium 700) (Reason (str-cat "Young and married driver that lives in " ?UsState)) (Type partial)))
)

(defrule driver-premiums::increase-young-and-married-driver2
  (EligibilityDecision (Name ?Name) (Decision eligible))
  (Client (Name ?Name) (MaritalStatus married) (UsState ?UsState & :(not (member$ ?UsState (create$ CA NY VA)))))
  (ClientFacts (Name ?Name) (Type young))
=>
  (assert (DriverPremium (Name ?Name) (Premium 300) (Reason (str-cat "Young and single driver that lives in " ?UsState)) (Type partial)))
)

(defrule driver-premiums::increase-young-and-single-driver1
  (EligibilityDecision (Name ?Name) (Decision eligible))
  (Client (Name ?Name) (MaritalStatus single) (UsState ?UsState & :(member$ ?UsState (create$ CA NY VA))))
  (ClientFacts (Name ?Name) (Type young))
=>
  (assert (DriverPremium (Name ?Name) (Premium 720) (Reason (str-cat "Young and single driver that lives in " ?UsState)) (Type partial)))
)

(defrule driver-premiums::increase-young-and-single-driver2
  (EligibilityDecision (Name ?Name) (Decision eligible))
  (Client (Name ?Name) (MaritalStatus single) (UsState ?UsState & :(not (member$ ?UsState (create$ CA NY VA)))))
  (ClientFacts (Name ?Name) (Type young))
=>
  (assert (DriverPremium (Name ?Name) (Premium 300) (Reason (str-cat "Young and single driver that lives in " ?UsState)) (Type partial)))
)

(defrule driver-premiums::increase-senior-driver1
  (EligibilityDecision (Name ?Name) (Decision eligible))
  (Client (Name ?Name) (UsState ?UsState & :(member$ ?UsState (create$ CA NY VA))))
  (ClientFacts (Name ?Name) (Type senior))
=>
  (assert (DriverPremium (Name ?Name) (Premium 500) (Reason (str-cat "Senior driver that lives in " ?UsState)) (Type partial)))
)

(defrule driver-premiums::increase-senior-driver2
  (EligibilityDecision (Name ?Name) (Decision eligible))
  (Client (Name ?Name) (UsState ?UsState & :(not (member$ ?UsState (create$ CA NY VA)))))
  (ClientFacts (Name ?Name) (Type senior))
=>
  (assert (DriverPremium (Name ?Name) (Premium 200) (Reason (str-cat "Senior driver that lives in " ?UsState)) (Type partial)))
)

(defrule driver-premiums::increase-typical-driver
  (EligibilityDecision (Name ?Name) (Decision eligible))
  (ClientFacts (Name ?Name) (Type ~young & ~senior))
=>
  (assert (DriverPremium (Name ?Name) (Premium 0) (Reason "Typical driver") (Type partial)))
)

(defrule driver-premiums::increase-accidents-premiums
  (EligibilityDecision (Name ?Name) (Decision eligible))
  (Client (Name ?Name) (NoA ?NoA))
=>
  (assert (DriverPremium (Name ?Name) (Premium (* ?NoA 150)) (Reason (str-cat "Driver has " ?NoA " accidents" )) (Type partial)))
)

(defrule driver-premiums::create-initial-sum-of-driver-premiums
  (DriverPremium (Name ?Name) (Type partial))
  (not (DriverPremium (Name ?Name) (Type total)))
=>
  (assert (DriverPremium (Name ?Name) (Premium 0) (Type total)))
  (printout t "driver-premiums::create-initial-sum-of-driver-premiums: Adding initial element for sum of driver premiums for " ?Name crlf)
)

(defrule driver-premiums::sum-and-display-driver-premiums
  ?DriverPremium <- (DriverPremium (Name ?Name) (Premium ?Premium) (Reason ?Reason) (Type partial))
  ?ToalDriverPremiums <- (DriverPremium (Name ?Name) (Premium ?TotalPremium) (Type total))
=>
  (modify ?ToalDriverPremiums (Premium (+ ?TotalPremium ?Premium)))
  (retract ?DriverPremium)
  (printout t "driver-premiums::sum-and-display-driver-premiums: Driver Premium for " ?Name ": " ?Premium "$ Reason: " ?Reason crlf)
)

(defrule car-discounts::decrease-only-driver-airbag
  (EligibilityDecision (Name ?Name) (Decision eligible))
  (Car (Owner ?Name) (Name ?CarName) (AirBags $?AirBags & :(subsetp ?AirBags (create$ driver)) & :(eq (length$ ?AirBags) 1)))
=>
  (assert (CarDiscount (Owner ?Name) (Name ?CarName) (Discount 12) (Reason "Car has only driver airbag") (Type partial)))
)

(defrule car-discounts::decrease-only-driver-and-passenger-airbags
  (EligibilityDecision (Name ?Name) (Decision eligible))
  (Car (Owner ?Name) (Name ?CarName) (AirBags $?AirBags & :(subsetp ?AirBags (create$ driver passenger)) & :(eq (length$ ?AirBags) 2)))
=>
  (assert (CarDiscount (Owner ?Name) (Name ?CarName) (Discount 15) (Reason "Car has driver and passengers airbags") (Type partial)))
)

(defrule car-discounts::decrease-only-driver-and-passenger-and-side-airbags
  (EligibilityDecision (Name ?Name) (Decision eligible))
  (Car (Owner ?Name) (Name ?CarName) (AirBags $?AirBags & :(subsetp ?AirBags (create$ driver passenger side)) & :(eq (length$ ?AirBags) 3)))
=>
  (assert (CarDiscount (Owner ?Name) (Name ?CarName) (Discount 18) (Reason "Car has driver, passengers and side airbags") (Type partial)))
)

(defrule car-discounts::decrease-has-alarm
  (EligibilityDecision (Name ?Name) (Decision eligible))
  (Car (Owner ?Name) (Name ?CarName) (HasAlarm true))
  (CarFacts (Owner ?Name) (Name ?CarName) (PTR high))
=>
  (assert (CarDiscount (Owner ?Name) (Name ?CarName) (Discount 10) (Reason "Car has high rating of potential theft but is has an alarm") (Type partial)))
)

(defrule car-discounts::create-initial-sum-of-car-discounts
  (CarDiscount (Owner ?Driver) (Name ?CarName) (Type partial))
  (not (CarDiscount (Owner ?Driver) (Name ?CarName) (Type total)))
=>
  (assert (CarDiscount (Owner ?Driver) (Name ?CarName) (Discount 0) (Type total)))
  (printout t "car-discounts::create-initial-sum-of-car-discounts: Adding initial element for sum of car dicounts for " ?Driver "'s " ?CarName crlf)
)

(defrule market-segment-discounts::preffered-client
  (EligibilityDecision (Name ?Name) (Decision eligible))
  (Client (Name ?Name) (Type $?Type & :(member$ preffered ?Type)))
=>
  (assert (MarketSegmentDiscount (Name ?Name) (Discount 250) (Reason (str-cat ?Name " is a preffered client")) (Type partial)))
)

(defrule market-segment-discounts::elite-client
  (EligibilityDecision (Name ?Name) (Decision eligible))
  (Client (Name ?Name) (Type $?Type & :(member$ elite ?Type)))
=>
  (assert (MarketSegmentDiscount (Name ?Name) (Discount 500) (Reason (str-cat ?Name " is an elite client")) (Type partial)))
)

(defrule market-segment-discounts::create-initial-sum-of-market-segment-discounts
  (MarketSegmentDiscount (Name ?Client) (Type partial))
  (not (MarketSegmentDiscount (Name ?Client) (Type total)))
=>
  (assert (MarketSegmentDiscount (Name ?Client) (Discount 0) (Type total)))
  (printout t "market-segment-discounts::create-initial-sum-of-market-segment-discounts: Adding initial element for sum of market segment dicounts for " ?Client crlf)
)

(defrule market-segment-discounts::sum-and-display-market-segment-discounts
  ?MarketSegmentDiscount <- (MarketSegmentDiscount (Name ?Client) (Discount ?Discount) (Reason ?Reason) (Type partial))
  ?ToalMarketSegmentDiscount <- (MarketSegmentDiscount (Name ?Client) (Discount ?TotalDiscount) (Type total))
=>
  (modify ?ToalMarketSegmentDiscount (Discount (+ ?TotalDiscount ?Discount)))
  (retract ?MarketSegmentDiscount)
  (printout t "market-segment-discounts::sum-and-display-market-segment-discounts: Market Segment Discount for " ?Client ": " ?Discount "$ Reason: " ?Reason crlf)
)

(defrule MAIN::summary-not-eligible
  (EligibilityDecision (Name ?Name) (Decision notEligible))
=>
  (printout t crlf "########### SUMMARY ###########" crlf "The client " ?Name " is not eligible for isurance" crlf)
)

(defrule MAIN::summary-revire
  (EligibilityDecision (Name ?Name) (Decision review))
=>
  (printout t crlf "########### SUMMARY ###########" crlf "The client " ?Name " is must be revied" crlf)
)

(defrule MAIN::summary-eligible
  (EligibilityDecision (Name ?Name) (Decision eligible))
  (CarFacts (Owner ?Name) (Name ?CarName) (BasePremium ?BasePremium))
  (CarPremium (Owner ?Name) (Name ?CarName) (Premium ?CarPremium) (Type total))
  (DriverPremium (Name ?Name) (Premium ?DriverPremium) (Type total))
  (CarDiscount (Owner ?Name) (Name ?CarName) (Discount ?CarDiscount) (Type total))
  (MarketSegmentDiscount (Name ?Name) (Discount ?MarketSegmentDiscount) (Type total))
  ?Insurance <- (Insurance (Client ?Name) (Premium ?FinalPremium & :(eq ?FinalPremium 0)))
=>
  (printout t crlf "########### SUMMARY ###########" crlf "The client " ?Name " is eligible for insurance" crlf)
  (printout t " - Base premium: " ?BasePremium "$" crlf)
  (printout t " - Driver premium: " ?DriverPremium "$" crlf)
  (printout t " - " ?CarName " premium: " ?CarPremium "$" crlf)
  (printout t " - " ?CarName " discount: " ?CarDiscount "%" crlf)
  (printout t " - Client discount: " ?MarketSegmentDiscount "$" crlf)
  (bind ?result (+ ?BasePremium ?DriverPremium (* ?CarPremium (- 1 (/ ?CarDiscount 100))) (- 0 ?MarketSegmentDiscount)))
  (modify ?Insurance (Premium ?result))
)

(defrule MAIN::summary-check-final-premium
  (EligibilityDecision (Name ?Name) (Decision eligible))
  (CarFacts (Owner ?Name) (Name ?CarName) (BasePremium ?BasePremium))
  ?Insurance <- (Insurance (Client ?Name) (Premium ?FinalPremium & :(< ?FinalPremium ?BasePremium)))
=>
  (modify ?Insurance (Premium ?BasePremium))
  (printout t "MAIN::summary-check-final-premium: The final premium (" ?FinalPremium "$) canot be lower than the base premium (" ?BasePremium "$). Setting final premium to base premium." crlf)
)

(defrule MAIN::summary-print-final-premium
  (EligibilityDecision (Name ?Name) (Decision eligible))
  (CarFacts (Owner ?Name) (Name ?CarName) (BasePremium ?BasePremium))
  (Insurance (Client ?Name) (Premium ?FinalPremium & :(>= ?FinalPremium ?BasePremium)))
=>
  (printout t "-------------------------------------------------------------" crlf)
  (printout t "Final premium for client " ?Name " is: " ?FinalPremium "$" crlf)
  (printout t "-------------------------------------------------------------" crlf)
)

(defrule car-discounts::sum-and-display-car-discounts
  ?CarDiscount <- (CarDiscount (Owner ?Driver) (Name ?CarName) (Discount ?Discount) (Reason ?Reason) (Type partial))
  ?ToalCarDiscount <- (CarDiscount (Owner ?Driver) (Name ?CarName) (Discount ?TotalDiscount) (Type total))
=>
  (modify ?ToalCarDiscount (Discount (+ ?TotalDiscount ?Discount)))
  (retract ?CarDiscount)
  (printout t "car-discounts::sum-and-display-car-discounts: Car Discount for " ?Driver "'s " ?CarName ": " ?Discount "$ Reason: " ?Reason crlf)
)


(set-static-constraint-checking TRUE)
(set-fact-duplication TRUE)
(reset)
(focus
  automobile-eligibility-potential-theft
  automobile-eligibility-potential-occupant-injury
  automobile-eligibility-calculation
  driver-eligibility-driver-age
  driver-eligibility-driver-certification
  driver-eligibility-driver-records
  driver-eligibility-calculation
  eligibility-scoring
  car-base-premiums
  car-premiums
  driver-premiums
  car-discounts
  market-segment-discounts
)
(run)
(exit)
