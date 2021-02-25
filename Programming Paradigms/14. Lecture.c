

int main() {
    int numAgents = 10;
    int numTickets = 150;
    for (int agent = 1; agent < numAgents ; agent++) {
        sellTickets(agent, numTickets, numAgents);
    }

    return 0;   
}

void sellTicket(int agent, int numTicketsToSell) {
    while (numTicketsToSell > 0) {
        printf("Agent %d sells a ticket\n");
    }
}
