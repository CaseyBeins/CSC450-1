/*
 * main.cpp
 *
 *  Created on: Sep 29, 2024
 *      Author: casey
 */

#include <iostream>
#include <thread>
#include <mutex>

// Mutex for synchronizing thread execution
std::mutex mtx;

// Function to count up to 20
void countUp() {
    for (int i = 1; i <= 20; ++i) {
        std::lock_guard<std::mutex> lock(mtx);  // Locking the mutex
        std::cout << "Counting up: " << i << std::endl;
        std::this_thread::sleep_for(std::chrono::milliseconds(200));  // Sleep to simulate work
    }
}

// Function to count down to 0
void countDown() {
    for (int i = 20; i >= 0; --i) {
        std::lock_guard<std::mutex> lock(mtx);  // Locking the mutex
        std::cout << "Counting down: " << i << std::endl;
        std::this_thread::sleep_for(std::chrono::milliseconds(200));  // Sleep to simulate work
    }
}

int main() {
    // Create thread for counting up
    std::thread thread1(countUp);

    // Wait for thread1 to finish
    thread1.join();

    // Create thread for counting down
    std::thread thread2(countDown);

    // Wait for thread2 to finish
    thread2.join();

    std::cout << "Both threads have completed execution." << std::endl;

    return 0;
}



