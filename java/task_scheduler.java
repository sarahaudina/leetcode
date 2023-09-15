// Intuition: The final result will be the total number of tasks, added with the number of cooldown period needed. Cooldown periods are the product of time needed for one idle period times the number of total idle period needed  
// Idle period are spaces between two adjacent tasks with the same type, so the biggest number of spaces will be needed if task with highest frequency positioned next to another. We can count how many potential spaces needed by placing highest frequency task as if they are the only kind of task exist. 
// So for case 1 -> A_ _ A _ _A -> 4 spaces
// Then tasks with lower frequency can be positioned in those potential spaces. So the total number of space needed can be counted by placing the other task in potential spaces.

// Strategy: Greedy.
// First, count frequency of each task and get the number of highest potential spaces, which is the frequency of highest frequency task, reduced by 1. Then iterate through the other task's frequency, using the frequency of each task to reduce the number of potential spaces needed. The final result will be the total number of tasks, added with the number of potential spaces left.

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Count frequency for every kind of task.
        int[] counter = new int[26];
        for (char task : tasks) {
            counter[task-'A']++;
        }

        // Sort ascending
        Arrays.sort(counter);

        // Get value of potential highest number of idle period
        int max = counter[25]-1;
        // Total spaces
        int totalSpace = max*n;

        // Reduce total idle period by filling the spaces with the rest of the tasks
        for (int i=24; i>=0; i--) {
            // In case there are multiple task have the highest frequency, reduce the total spaces with the highest potential spaces instead of the task's frequency'
            totalSpace -= Math.min(counter[i], max);
        }

        // In case the total spaces lower than 0
        totalSpace = Math.max(0, totalSpace);

        return tasks.length + totalSpace;
    }
}