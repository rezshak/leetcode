// https://leetcode.com/problems/employee-free-time/

package main

import (
	"fmt"
	"sort"
)

type Interval struct {
	Start int
	End   int
}

func (i Interval) String() string {
	return fmt.Sprintf("[%d, %d]", i.Start, i.End)
}

// T: O(nlogn), S: O(n)
func employeeFreeTime(schedule [][]*Interval) []*Interval {
	var allIntervals []*Interval

	for _, empSchedule := range schedule {
		allIntervals = append(allIntervals, empSchedule...)
	}

	sort.Slice(allIntervals, func(i, j int) bool {
		return allIntervals[i].Start < allIntervals[j].Start
	})

	var result []*Interval
	prevEnd := allIntervals[0].End

	for _, interval := range allIntervals[1:] {
		if interval.Start > prevEnd {
			result = append(result, &Interval{Start: prevEnd, End: interval.Start})
		}
		if interval.End > prevEnd {
			prevEnd = interval.End
		}
	}

	return result
}

func main() {
	schedule1 := [][]*Interval{
		{{1, 2}, {5, 6}},
		{{1, 3}},
		{{4, 10}},
	}
	fmt.Println(employeeFreeTime(schedule1)) // [[3,4]]
	schedule2 := [][]*Interval{
		{{1, 3}, {6, 7}},
		{{2, 4}},
		{{2, 5}, {9, 12}},
	}
	fmt.Println(employeeFreeTime(schedule2)) // [[5,6],[7,9]]
}
