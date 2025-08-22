print(" 1.Push \n 2.Pop \n 3.Peak \n 4.Display \n 5.Exit")
i = 0
def push(x):
    stack.append(x)
    print(f"{x} Added to the stack")
def pop():
    print(f"{stack[len(stack)-1]} is removed from Stack.")
    stack.pop()
def dis():
    print(stack)
def peek():
    print(f"{stack[len(stack)-1]}")
n = 0
i = int(input("Initiate Stack Size To Begain With!"))
stack = [None]*i
while n != 5:
    n = int(input("Enter the Option:"))
    if n == 1:
        x = int(input("Value:"))
        push(x)
    elif n == 2:
        if len(stack) == 0:
            print("No Element To remove")
        else:
            pop()
    
    elif n == 3:
        if len(stack) == 0:
            print("Stack is Empty!!")
        else:
            peek()
    
    elif n == 4:
        dis()
    
    elif n == 5:
        print("Exiting Stack....")
        exit()