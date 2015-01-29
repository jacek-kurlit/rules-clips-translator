(deffacts initial-facts
 (driver
 (class 1)
 (age 29)
 (licage 2))
 (car (capacity 997) (age 12) (historic false) (seats 5) (technical true) (accidents 0))
 (insurance (continue true) (cars 1) (payment single) (otherins false) (certificate true))
)

(defmodule MAIN (export deftemplate ?ALL) (export defglobal ?ALL) (import car deftemplate a b c) (import deftemplate person ?ALL))

(defglobal globals ?*x* = 3 ?*y* = ?*x* ?*z* = (+ ?*x* ?*y*)
   ?*q* = (create$ a b c))

(deftemplate car
  (slot capacity
    (type INTEGER)
    (range 0 10000)
  )
  (slot age
    (type INTEGER)
    (range 0 200)
  )
  (slot historic
    (type SYMBOL)
    (allowed-symbols true false)
    (default false)
  )
  (slot seats
    (type INTEGER)
    (range 1 10)
  )
  (slot technical
    (type SYMBOL)
    (allowed-symbols true false)
    (default true)
  )
  (slot accidents
    (type INTEGER)
    (range 0 366)
    (default 0)
  )
)

(deftemplate driver (slot class (type INTEGER) (range -1 9) (default 1)) (slot age (type INTEGER) (range 18 120)) (slot licage (type INTEGER) (range 0 102)))

(deftemplate insurance
  (slot continue
    (type SYMBOL)
    (allowed-symbols true false)
    (default false)
  )
  (slot cars
    (type INTEGER)
    (range 1 1000)
    (default 1)
  )
  (slot payment
    (type SYMBOL)
    (allowed-symbols single instalments)
    (default instalments)
  )
  (slot otherins
    (type SYMBOL)
    (allowed-symbols true false)
    (default false)
  )
  (slot certificate
    (type SYMBOL)
    (allowed-symbols true false)
    (default true)
  )
)

(defmodule MAIN
  (export deftemplate ?ALL)
)
(defmodule bonus-malus
  (import MAIN deftemplate ?ALL)
)
(defmodule base-charge
  (import MAIN deftemplate ?ALL)
)

(defmodule base-charge-modifiers
  (import MAIN deftemplate ?ALL)
)

(deftemplate base
   (slot value
     (type NUMBER)
   )
)

(deftemplate base-modifier
  (slot value (type NUMBER) )
)

(deftemplate result
  (slot value
    (type NUMBER)
  )
)

(defrule bonus-malus::bonus-malus0
  ?driver <- (driver (class ?class&:(< ?class 9)))
  (car (accidents 0))
=>
  (modify ?driver (class (+ ?class 1)))
  (printout t "Driver class has been increased from " ?class " to " (+ ?class 1) crlf)
  (pop-focus)
)

(defrule bonus-malus::bonus-malus1-1
  ?driver <- (driver (class ?class&:(member$ ?class (create$ 0 1))))
  (car (accidents 1))
=>
  (modify ?driver (class (- ?class 1)))
  (printout t "Driver class has been dereased from " ?class " to " (- ?class 1) crlf)
  (pop-focus)
)

(defrule bonus-malus::bonus-malus1-2
  ?driver <- (driver (class ?class&:(member$ ?class (create$ 2 3 4 5 8 9))))
  (car (accidents 1))
=>
  (modify ?driver (class (- ?class 2)))
  (printout t "Driver class has been dereased from " ?class " to " (- ?class 2) crlf)
  (pop-focus)
)

(defrule bonus-malus::bonus-malus1-3
  ?driver <- (driver (class ?class&:(member$ ?class (create$ 6 7))))
  (car (accidents 1))
=>
  (modify ?driver (class (- ?class 3)))
  (printout t "Driver class has been dereased from " ?class " to " (- ?class 3) crlf)
  (pop-focus)
)

(defrule bonus-malus::bonus-malus2-1
  ?driver <- (driver (class ?class&:(member$ ?class (create$ 0 1 2))))
  (car (accidents 2))
=>
  (modify ?driver (class -1))
  (printout t "Driver class has been dereased from " ?class " to -1" crlf)
  (pop-focus)
)

(defrule bonus-malus::bonus-malus2-2
  ?driver <- (driver (class ?class&:(member$ ?class (create$ 3 4))))
  (car (accidents 2))
=>
  (modify ?driver (class (- ?class 3)))
  (printout t "Driver class has been dereased from " ?class " to " (- ?class 3) crlf)
  (pop-focus)
)

(defrule bonus-malus::bonus-malus2-3
  ?driver <- (driver (class ?class&:(member$ ?class (create$ 5 6 7))))
  (car (accidents 2))
=>
  (modify ?driver (class (- ?class 4)))
  (printout t "Driver class has been dereased from " ?class " to " (- ?class 4) crlf)
  (pop-focus)
)

(defrule bonus-malus::bonus-malus2-4
  ?driver <- (driver (class ?class&:(member$ ?class (create$ 8 9))))
  (car (accidents 2))
=>
  (modify ?driver (class (- ?class 5)))
  (printout t "Driver class has been dereased from " ?class " to " (- ?class 5) crlf)
  (pop-focus)
)

(defrule bonus-malus::bonus-malus3-1
  ?driver <- (driver (class ?class&:(< ?class 9)))
  (car (accidents ?accidents&:(> ?accidents 2)))
=>
  (modify ?driver (class -1))
  (printout t "Driver class has been dereased from " ?class " to -1" crlf)
  (pop-focus)
)

(defrule bonus-malus::bonus-malus3-2
  ?driver <- (driver (class 9))
  (car (accidents ?accidents&:(> ?accidents 2)))
=>
  (modify ?driver (class 0))
  (printout t "Driver class has been dereased from 9 to 0" crlf)
  (pop-focus)
)

(defrule base-charge::base-charge1
  (car (capacity ?capacity&:(< ?capacity 900)))
=>
  (assert (base (value 537)))
  (assert (result (value 537)))
  (printout t "The base charge is set to 537" crlf)
)

(defrule base-charge::base-charge2
  (car (capacity ?capacity&:(>= ?capacity 900)&:(< ?capacity 1300)))
=>
  (assert (base (value 753)))
  (assert (result (value 753)))
  (printout t "The base charge is set to 753" crlf)
)

(defrule base-charge::base-charge3
  (car (capacity ?capacity&:(>= ?capacity 1300)&:(< ?capacity 1600)))
=>
  (assert (base (value 1050)))
  (assert (result (value 1050)))
  (printout t "The base charge is set to 1050" crlf)
)

(defrule base-charge::base-charge4
  (car (capacity ?capacity&:(>= ?capacity 1600)&:(< ?capacity 2000)))
=>
  (assert (base (value 1338)))
  (assert (result (value 1338)))
  (printout t "The base charge is set to 1338" crlf)
)

(defrule base-charge::base-charge5
  (car (capacity ?capacity&:(>= ?capacity 2000)))
=>
  (assert (base (value 1536)))
  (assert (result (value 1536)))
  (printout t "The base charge is set to 1536" crlf)
)


(defrule base-charge-modifiers::driver-class
  (driver (class ?class))
=>
  (assert (base-modifier (value (nth$ (+ ?class 2) (create$ 160 60 0 -10 -20 -30 -40 -40 -50 -50 -60)))))
  (printout t (+ 100 (nth$ (+ ?class 2) (create$ 160 60 0 -10 -20 -30 -40 -40 -50 -50 -60)))"% of base charge because of the driver class (" ?class ")" crlf)
)


(defrule base-charge-modifiers::decrease-driver-age
  (driver (age ?age&:(>= ?age 40)&:(<= ?age 55)))
=>
  (assert (base-modifier (value -10)))
  (printout t "-10% because of the driver age (" ?age ") that is between 40 and 55" crlf)
)

(defrule base-charge-modifiers::decrease-car-age
  (car (age ?age&:(<= ?age 2)))
=>
  (assert (base-modifier (value (+ -20 (* ?age 5)))))
  (printout t (+ -20 (* ?age 5)) "% because of the car age (" ?age ") that is younger than 3 years" crlf)
)

(defrule base-charge-modifiers::decrease-single-payment
  (insurance (payment single))
=>
  (assert (base-modifier (value -10)))
  (printout t "-10% because of the single payment" crlf)
)

(defrule base-charge-modifiers::decrease-insurance-continuation
  (insurance (continue true))
=>
  (assert (base-modifier (value -10)))
  (printout t "-10% because driver continues the previous agreement" crlf)
)

(defrule base-charge-modifiers::decrease-insurance-more-cars
  (insurance (cars ?cars&:(> ?cars 1)))
=>
  (assert (base-modifier (value -10)))
  (printout t "-10% because driver want to insured more than one car (" ?cars ")" crlf)
)

(defrule base-charge-modifiers::decrease-insurance-others-agreements
  (insurance (otherins true))
=>
  (assert (base-modifier (value -20)))
  (printout t "-20% because driver has also other agreements" crlf)
)

(defrule base-charge-modifiers::decrease-historic-car
  (car (historic true))
=>
  (assert (base-modifier (value -50)))
  (printout t "-50% because this is historic car" crlf)
)

(defrule base-charge-modifiers::increase-driver-age
  (driver (age ?age&:(< ?age 25)))
=>
  (assert (base-modifier (value 50)))
  (printout t "+50% because of the driver age (" ?age ") that is less than 25" crlf)
)

(defrule base-charge-modifiers::increase-driver-licage
  (driver (licage ?licage&:(< ?licage 3)))
=>
  (assert (base-modifier (value 30)))
  (printout t "+30% because of the small driver experience (" ?licage ") that is less than 3 years" crlf)
)

(defrule base-charge-modifiers::increase-car-age
  (car (age ?age&:(> ?age 10)))
=>
  (assert (base-modifier (value 15)))
  (printout t "+15% because of the car age (" ?age ") that is older than 10 years" crlf)
)

(defrule base-charge-modifiers::increase-car-seats
  (car (seats ?seats&:(>= ?seats 6)&:(<= ?seats 9)))
=>
  (assert (base-modifier (value 20)))
  (printout t "+20% because of the number of seats in the car (" ?seats ") that is between 6 and 9" crlf)
)

(defrule base-charge-modifiers::increase-car-technical
  (car (technical false))
=>
  (assert (base-modifier (value 20)))
  (printout t "+20% because of lack of valid technical inspection" crlf)
)

(defrule base-charge-modifiers::increase-instalments
  (insurance (payment instalments))
=>
  (assert (base-modifier (value 10)))
  (printout t "+10% because of the instalments" crlf)
)

(defrule base-charge-modifiers::increase-certificate
  (insurance (certificate false))
=>
  (assert (base-modifier (value 60)))
  (printout t "+60% because of the lack of previous insurance certificates" crlf)
)

(defrule MAIN::calculation
  (base (value ?basecharge))
  ?bm <- (base-modifier (value ?modifier))
  ?rs <- (result (value ?resultvalue))
=>
  (modify ?rs (value (+ ?resultvalue (* ?basecharge (/ ?modifier 100)))))
  (retract ?bm)
  (printout t "Modifying insurance value " ?resultvalue " by " ?modifier "% of basecharge " ?basecharge crlf)
)

(defrule MAIN::displayresult
  (not (base-modifier))
  (result (value ?resultvalue))
=>
  (printout t "The final amount to pay is equal to " ?resultvalue crlf)
)

(set-static-constraint-checking TRUE)
(set-fact-duplication TRUE)
(reset)
(focus bonus-malus base-charge base-charge-modifiers)
(run)
(exit)
