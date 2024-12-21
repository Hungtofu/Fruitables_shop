const buttons = document.querySelectorAll('.list-group-item-action');
        buttons.forEach(button => {
            button.addEventListener('click', () => {
                const target = button.getAttribute('data-target');

                // Hide all content
                document.querySelectorAll('.p-3.bg-light').forEach(section => {
                    section.classList.add('d-none');
                });

                // Remove active class from all buttons
                buttons.forEach(btn => btn.classList.remove('active'));

                // Show the selected content and add active class
                if (target) {
                    document.getElementById(target).classList.remove('d-none');
                    button.classList.add('active');
                }
            });
        });