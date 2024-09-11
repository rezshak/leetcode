// https://leetcode.com/problems/design-parking-system/

package main

import "fmt"

type ParkingSystem struct {
	slots []int
}

func Constructor(big, medium, small int) ParkingSystem {
	return ParkingSystem{slots: []int{0, big, medium, small}}
}

// T: O(1), S: O(1)
func (ps *ParkingSystem) AddCar(carType int) bool {
	if ps.slots[carType] > 0 {
		ps.slots[carType]--
		return true
	}
	return false
}

func main() {
	ps := Constructor(1, 1, 0)
	fmt.Println(ps.AddCar(1)) // true
	fmt.Println(ps.AddCar(2)) // true
	fmt.Println(ps.AddCar(3)) // false
}
