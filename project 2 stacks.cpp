#include <iostream>
#include <cassert>
#include <string>
using namespace std;

template <class Type>
class stackADT
{
public:
	virtual void initializeStack() = 0;
	virtual bool isEmptyStack() const = 0;
	virtual bool isFullStack() const = 0;
	virtual void push(const Type& newItem) = 0;
	virtual Type top() const = 0;
	virtual void pop() = 0;
};

template <class Type>
class stackType : public stackADT<Type>
{
private:
	int maxStackSize;
	int stackTop;
	Type* list;
public:
	void initializeStack()
	{
		stackTop = 0;
	}

	void print()
	{
		for (int i = 0; i < stackTop; i++)
		{
			cout << list[i] << endl;
		}
	}

	bool isEmptyStack() const
	{
		return(stackTop == 0);
	}

	bool isFullStack() const
	{
		return(stackTop == maxStackSize);
	}

	void push(const Type& newItem)
	{
		if (!isFullStack())
		{
			list[stackTop] = newItem;
			stackTop++;
		}
		else
		{
			cout << "Cannot add to a full stack." << endl;
		}
	}

	Type top() const
	{
		assert(stackTop != 0); //if stack is empty, terminate the program.                            
		return list[stackTop - 1];
	}

	void pop()
	{
		if (!isEmptyStack())
			stackTop--;
		else
			cout << "Cannot remove from an empty stack." << endl;
	}

	stackType(int stackSize = 100)
	{
		if (stackSize <= 0)
		{
			cout << "Size of the array to hold the stack must be positive." << endl;
			cout << "Creating an array of size 100." << endl;
			maxStackSize = 100;
		}
		else
		{
			maxStackSize = stackSize;
		}

		stackTop = 0;
		list = new Type[maxStackSize];
	}

	stackType(const stackType<Type>& otherStack)
	{
		list = NULL;
		copyStack(otherStack);
	}

	~stackType()
	{
		delete[] list;
	}

	const stackType<Type>& operator=(const stackType<Type>& otherStack)
	{
		if (this != &otherStack)
		{
			copyStack(otherStack);
		}
		return *this;
	}

	bool operator==(const stackType<Type>& otherStack) const
	{
		if (this == &otherStack)
		{
			return true;
		}
		else
		{
			if (stackTop != otherStack.stackTop)
			{
				return false;
			}
			else
			{
				for (int i = 0; i < stackTop; i++)
				{
					if (list[i] != otherStack.list[i])
					{
						return false;
					}
					return true;
				}
			}
		}
	}

	void copyStack(const stackType<Type>& otherStack)
	{
		delete[] list;
		maxStackSize = otherStack.maxStackSize;
		stackTop = otherStack.stackTop;

		list = new Type[maxStackSize];

		//copy otherStack into this stack. 
		for (int j = 0; j < stackTop; j++)
		{
			list[j] = otherStack.list[j];
		}
	}
};

int main()
{
	int choice;
	cout << "Integer (1) or Decimal Number (2) to convert?" << endl;
	cin >> choice;

	if (choice == 1)
	{
		string input;
		cout << "Please provide integer number" << endl;
		cin >> input;

		int i = 0;
		for (char c : input)
		{
			if (c >= '0' && c <= '9')
			{
				i = i * 10 + (c - '0');
			}
		}
		cout << "Converted Integer: " << i << endl;
	}

		if (choice == 2)
		{
			string input;
			cout << "Please provide decimal number" << endl;
			cin >> input;

			int i = 0;
			double d = 0.0;

			for (char c : input)
			{
				if (c >= '0' && c <= '9')
				{
					i = i * 10 + (c - '0');
				}
				else break;
			}

			stackType<int> stack1(50);
			stack1.initializeStack();

			for (char c : input)
			{
				stack1.push(c);
			}

			while (stack1.top() != '.')
			{
				d = (d + (stack1.top() - '0'))/10;
				stack1.pop();
			}

			double final = i + d;
			cout << "Converted decimal number: " << final << endl;

		}

		return 0;

}